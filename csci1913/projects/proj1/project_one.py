from math import floor
from random import choice,randint

# translating integer from board to the string version
int_to_stone = {
    0: " ",
    1: "●", # black
    2: "○" # white
}

def get_starting_index(row: int, column: int) -> int:
    '''
    Purpose: returns the initial stone color (via integer) for the starting board given the row and column
    args: 
    row: int - row index
    column: int - column index
    returns:
    int - the number stone to start the row with
    '''
    if row % 2 == 0:
        return 1 if column % 2 == 0 else 2
    else:
        return 2 if column % 2 == 0 else 1
    


def generate_board(n):
    '''
    Purpose: generates square board of nxn dimensions
    args:
    n: int - square dimension of generated board
    returns:
    list[int[]] - generated board
    '''
    board = []

    if n <= 0:
        return board

    for i in range(n):
        row = []
        for j in range(n):
            row.append(get_starting_index(i,j))
        board.append(row)
    return board




def get_board_as_string(board):
    '''
    Purpose: generates a string for user friendly version of the board
    args:
    board: listint[]] - game board
    returns:
    str - game board as string with column/row indices, grid pattern, and colored stones
    '''

    board_str = ""
    board_str += "   " + " ".join([str(i%10) for i in range(len(board[0]))]) + "\n"
    for i in range(len(board) * 2):
        if i % 2 == 0:
            board_str += ("  ")
            board_str += ("+-"*len(board[floor(i/2)]))
            board_str += ("+\n")
        else:
            board_str += str(floor(i/2)%10) + " "
            for j in range(len(board[floor(i/2)])):
                board_str += (f"|{int_to_stone[board[floor(i/2)][j]]}")
            board_str += ("|\n")
    
    board_str += ("  ")
    board_str += ("+-"*len(board[floor(i/2)]))
    board_str += ("+\n")
    return board_str

def prompt_user_move():
    '''
    Purpose: promp a user for a position
    Args:
    None
    Returns:
    tuple(int,int) - position the user entered as an easily accesible tuple
    '''
    # prompts the user for one locations

    # must do validation at some point
    row = int(input("Enter a row value:  "))
    column = int(input("Enter a column value:  "))
    

    return (row,column)

def is_edge(board,row,column) -> bool:
    '''
    Purpose: to help determine if a position is on the edge of a board. Mainly for validating moves
    Args:
    row: int - row index
    column: int - column index
    '''
    # returns true if the given location is on the edge of the board
    # assumes rectangular board
    return column <= 0 or column >= len(board[0]) or row <= 0 or row >= len(board)-1

def in_board(board, pos):
    '''
    Purpose: determines if a position is within the bounds a board
    Arguments:
    board: list[int[]] - game board
    pos: tuple(int, int)
    Returns:
    bool - true if in board, false otherwise
    '''
    row,column = pos
    return not (row < 0 or row > len(board) - 1 or column < 0 or column > len(board[0]) - 1)

def prep_board_human(board):
    '''
    Purpose: Repeatedly prompts user for a move, 
    args:
    board: list[int[]] - game board
    returns:
    None - this method mutates the board arg in place
    '''
    print(get_board_as_string(board))

    valid = False

    # get location 1
    while not valid:
        # must do input validation at some point
        loc1 = prompt_user_move()

        row1,column1 = loc1
        
        valid = not is_edge(board,row1,column1) 
        if not valid:
            print("Please pick a different stone")
                 
    valid = False

    # get location 2
    while not valid:
        loc2 = prompt_user_move()
        
        row2, column2 = loc2

        valid = (not is_edge(board,row2,column2)# not on edge
                 and board[row1][column1] != board[row2][column2] # not the same color stone
                 and loc1 != loc2 ) # not the same location
        if not valid:
            print("Please pick a different stone")
        
    board[row1][column1] = 0
    board[row2][column2] = 0


def get_sign(n):
    '''
    Purpose: returns the sign of a number. For clarity in code when determing the direction of a movement
    args:
    n: int - number
    returns:
    int - -1 if negative, otherwise 1
    '''

    # returns the sign of a number
    return -1 if n < 0 else 1

def is_valid_move(board, move):
    '''
    Purpose: determines if the given move is a valid one
    args:
    board: list[int[]] - game board
    move: tuple(tuple(int,int),tuple(int,int)) - move where the first tuple is the start and the second is the end
    returns:
    bool: true if the move is valid, false otherwise
    '''
    start, end = move

    row1, column1 = start
    row2, column2 = end

    # not a valid position (negative/outside of the board)
    if not in_board(board,start) or not in_board(board,end):
        return False

    if board[row1][column1] == board[row2][column2]:
        return False

    # same colored stone
    
    
    # end space is not empty
    if board[row2][column2] != 0:
        return False
   
    row_distance = row2 - row1
    column_distance = column2 - column1

    # imagine each move as a vector from the starting position -> ending position
    # vector between start and end should be some multiple of 2 because of the number of 
    # jumps to be made
    # each multiple of 2 prior to that should be empty
    # probably could iterate by just checking each position and seeing if it is empty

    # distance must be within the move radius of a stone
    # how do we account for vectors that are straight, but don't have valid jumps
    # recursive call to find if it s a valid move from the current position -> next jump
    if (row_distance % 2 == 0 and column_distance % 2 != 0) or (row_distance % 2 != 0 and column_distance % 2 == 0):
        return False
    
    # if one of the components of the move is 2,
    # then the other must be zero in order for the move to be in a cardinal direction
    if row_distance != 0 and column_distance != 0:
        return False

    # get the direction of the movement +/- x or +/- y
    direction = row_distance if column_distance == 0 else column_distance

    # always an integer because we checked that the direction was
    # checking each jump 
    # safe bc start/end are valid positions, so anything in between is also a valid position
    # divide by two to get the number of moves to check

    for i in range(1,abs(direction)):
        
        if direction == row_distance:
            possible_position = (start[0] + i*get_sign(direction),start[1])
            
        else:
            possible_position = (start[0],start[1] + i*get_sign(direction))
 
        row, column = possible_position
      
      
        if i % 2 != 0:
            if board[row][column] == 0:
                return False
        else:
            if board[row][column] != 0:

                return False

   

    return True
def add_vectors(v1, v2):
    '''
    Purpose: adding the vectors of two components
    args:
    v1: tuple(int,int)
    v2: tuple(int,int)
    returns:
    tuple(int,int) - a new "vector" representing the additon of the two input "vectors" v1, v2
    '''
    return (v1[0] + v2[0], v1[1] + v2[1])
def magnitude(v):
    '''
    Purpose: finding the magnitude of a vector
    args:
    v: tuple(int,int)
    returns:
    float: magnitude of a the input vector using the vector magnitude formula
    '''
    return (v[0]**2 + v[1]**2) ** 0.5

def calculate_vector(pos1: tuple,pos2: tuple):
    '''
    Purpose: finding the vector between two points
    args:
    pos1: tuple(int,int) - tuple representing the initial position
    pos2: tuple(int,int) - tuple representing the final position
    returns:
    tuple(int, int) - tuple representing the "vector" between pos1 and pos2
    '''
    return (pos2[0]-pos1[0],pos2[1]-pos1[1])

def get_valid_moves_for_stone(board, stone_pos):
    '''
    Purpose: find the valid moves in all four cardinal directions for a given stone
    args:
    board: list[int[]] - game board
    stone_pos: tuple(int,int) - tuple representing the stones position on the board
    returns:
    list[tuple(tuple(int,int),tuple(int,int))] - list of valid moves for a stone, where a move is a tuple(start_pos,end_pos)
    '''
    directions = [
        (0,2),  # right
        (0,-2), # donwn
        (2,0),  # left
        (-2,0)  # up
    ]

    moves = []

    for direction in directions:
        
        start_pos = stone_pos
        end_pos = start_pos
        possible_end_pos = add_vectors(stone_pos,direction)

        is_valid = in_board(board,start_pos) and in_board(board,possible_end_pos) and is_valid_move(board,(start_pos,possible_end_pos))
        i = 1

        while is_valid:
            
            possible_end_pos = add_vectors(start_pos,(direction[0]*i,direction[1]*i))

            moves.append((start_pos,end_pos))
            end_pos = possible_end_pos
            is_valid = in_board(board,start_pos) and in_board(board,possible_end_pos) and is_valid_move(board,(start_pos,possible_end_pos)) 
        
            i += 1
        

    def not_starting(s):
        return s != (stone_pos,stone_pos)
    
    return list(filter(not_starting,moves))


    
def get_valid_moves(board, stone):
    '''
    Purpose: finds the valid moves for every stone for a certain player
    args:
    board: list[int[]] - game board
    stone_pos: int - 1 for black, 2 for white
    returns:
    list[tuple(tuple(int,int),tuple(int,int))] - list of valid moves for all stones that match the stone argument
    '''
    valid_moves =  []
    for i in range(len(board)):
        for j in range(len(board[i])):

            moves = get_valid_moves_for_stone(board,(i,j))
            if board[i][j] == stone and moves != []:
                valid_moves += moves
    return valid_moves

def random_player(board,player):
    '''
    Purpose: randomly chooses a move from the available moves to the player
    args:
    board: list[int[]] - game board
    player: int - 1 for black, 2 for white
    returns:
    list(tuple(int,int)) | tuple() - returns a valid move or an empty tuple if none are available 
    '''
    moves = get_valid_moves(board,player)
    if len(moves) != 0:
        return choice(moves)
    else: 
        return tuple()
 
def human_player(board, player):
  
    '''
    Purpose: repeatedly prompts a user for a move, then subsequently make sthat move
    args:
    board: list[int[]] - game board
    player: int - 1 for black, 2 for white
    returns:
    list(tuple(int,int),tuple(int,int)) - returns the valid move a user makes
    '''
    moves = get_valid_moves(board,player)

    if len(moves) != 0:
        print(get_board_as_string(board))

        valid = False

        # get location 1
        while not valid:
            # must do input validation at some point
            loc1 = prompt_user_move()
            loc2 = prompt_user_move()

           
            
            valid = (loc1,loc2) in moves
            if not valid:
                print(f"({loc1},{loc2}) is not a valid move. Try again.")
        return (loc1,loc2)
    else:
        return ()

def ai_player(board, player):
    '''
    Purpose: chooses a move automaticlaly. Prioritizes the longeest moves first
    args:
    board: list[int[]] - game board
    player: int - 1 for black, 2 for white
    returns:
    list(tuple(int,int),tuple(int,int)) | tuple - returns the valid move the ai makes or nothing if it can't make a move
    '''
    moves = get_valid_moves(board,player)
    
    if len(moves) != 0:
        max = ((0,0),(0,0))
        for move in moves:
            move_vector = calculate_vector(move[1],move[0])
            max_move_vector = calculate_vector(max[1],max[0])
            if magnitude(move_vector) > magnitude(max_move_vector):
                max = move
        return max
    else:
        return tuple()
    
def make_move(board,move):
    '''
    Purpose: mutates a board given a move
    args:
    board: list[int[]] - game board
    move: (tuple(int,int),tuple(int,int)) - move the be made
    returns:
    None - mutates the board in place
    '''
    if is_valid_move(board,move):
      
        
        start_pos = move[0]
        end_pos = move[1]
    

        start_row,start_column = start_pos
        end_row,end_column = end_pos
        
        player = board[start_row][start_column]

        column_distance = end_column - start_column
        row_distance = end_row - start_row

        if row_distance == 0:
            direction = get_sign(column_distance)
            for i in range(abs(column_distance)):
                
                current_pos = board[start_row][start_column+direction*i]
                if current_pos != 0 and current_pos != player:
                    board[start_row][start_column+direction*i] = 0
        else:
            direction = get_sign(row_distance)
            for i in range(abs(row_distance)):
                current_pos = board[start_row + direction*i][start_column]
                if current_pos != 0 and current_pos != player:
                    board[start_row + direction*i][start_column] = 0
        board[start_row][start_column] = 0
        board[end_row][end_column] = player
        
    else:
        return None
def play_game(board):
    '''
    Purpose: simulates a game between two ai opponents
    args:
    board: list[int[]] - game board
    
    returns:
    int - winning player. 1 for black, 2 for white
    '''
    plays_first = randint(1,2)

    one_Has_Moves = len(get_valid_moves(board,1)) > 0
    two_Has_Moves = len(get_valid_moves(board,2)) > 0



    while one_Has_Moves and two_Has_Moves:

        if plays_first == 1 and one_Has_Moves:
            move = ai_player(board, 1)

            make_move(board,move)
            plays_first = 2
        elif plays_first == 2 and two_Has_Moves:
            move = ai_player(board, 2)

            make_move(board,move)
            plays_first = 1
       
        one_Has_Moves = len(get_valid_moves(board,1)) > 0
        two_Has_Moves = len(get_valid_moves(board,2)) > 0

        if not one_Has_Moves:
            return 2
        if not two_Has_Moves:
            return 1
    

