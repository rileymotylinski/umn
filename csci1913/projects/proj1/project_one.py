from math import floor

# translating integer from board to the string version
int_to_stone = {
    0: " ",
    1: "●", # black
    2: "○" # white
}

def get_starting_index(row: int, column: int) -> int:
    '''
    returns the initial stone color (via integer) for the starting board given the row and column
    '''
    if row % 2 == 0:
        return 1 if column % 2 == 0 else 2
    else:
        return 2 if column % 2 == 0 else 1
    


def generate_board(n):
    '''
    generates square board of nxn dimensions
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
    prints a user friendly version of the board
    '''

    board_str = ""
    board_str += "   " + " ".join([str(i%10) for i in range(len(board))]) + "\n"
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
    # prompts the user for one locations

    # must do validation at some point
    row = int(input("Enter a row value:  "))
    column = int(input("Enter a column value:  "))
    

    return (row,column)

def is_edge(board,row,column) -> bool:
    # returns true if the given location is on the edge of the board
    # assumes a square board

    if row <= 0 or row >= len(board)-1:
        return True
    if column <= 0 or column >= len(board):
        return True
    return False

def in_board(board, pos):
    row,column = pos

    # is the position within the bounds of the board
    if row < 0 or row > len(board) - 1:
        return False
    if column < 0 or column > len(board) - 1:
        return False
    return True

def prep_board_human(board):
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
    # reeturns the sign of a number
    return -1 if n < 0 else 1

def is_valid_move(board, move):
    start, end = move

    row1, column1 = start
    row2, column2 = end

    # not a valid position (negative/outside of the board)
    if not in_board(board,start) or not in_board(board,end):
        return False
    
    # same colored stone
    if board[row1][column1] == board[row2][column2]:
        return False
    
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
    if row_distance % 2 != 0 and column_distance % 2 != 0:
        return False
    
    # if one of the components of the move is 2,
    # then the other must be zero in order for the move to be in a cardinal direction
    if row_distance != 0 and column_distance != 0:
        return False

    # get the direction of the movement +/- x or +/- y
    direction = row_distance if column_distance == 0 else column_distance

    # probably not great to convert to list
    next_position = list(start)
    # always an integer because we checked that the direction was
    # checking each jump 
    # safe bc start/end are valid positions, so anything in between is also a valid position
    # divide by two to get the number of moves to check

    positions = []
    for i in range(direction // 2):

        possible_position = (start[0] + i*2*get_sign(direction),start[1] + i*2*get_sign(direction))

        if direction == row_distance:
            next_position[0] += get_sign(direction)*2
            
        else:
            next_position[1] += get_sign(direction)*2
        if not is_valid_move(board,(start,next_position)):
            return False
        start = list(next_position)

    return True



board = [[1,2,1,2],
        [2,0,2,1],
        [1,2,1,2],
        [2,1,2,1],]


print("Testing is_valid_move")

print(get_board_as_string(board))

assert is_valid_move(board, ((3, 1),(1, 1))) == True
assert is_valid_move(board, ((3, 2),(1, 1))) == False
assert is_valid_move(board, ((3, 3),(1, 1))) == False

board = [[1,2,1,2,1,2,1,2],
            [2,1,0,1,2,1,2,1],
            [1,2,1,2,1,2,1,2],
            [2,1,0,1,2,1,2,1],
            [1,2,1,2,1,2,1,2],
            [2,1,0,1,2,1,2,1],
            [1,2,1,2,1,2,1,2],
            [2,1,2,1,2,1,2,1],]

assert is_valid_move(board, ((7, 2),(1, 2))) == True
assert is_valid_move(board, ((7, 2),(3, 2))) == True
assert is_valid_move(board, ((5, 2),(3, 2))) == False
assert is_valid_move(board, ((5, 3),(3, 2))) == False
assert is_valid_move(board, ((6, 3),(3, 2))) == False
assert is_valid_move(board, ((7, 3),(3, 2))) == False

print("Passed is_valid_move tests")

print("########################################")

