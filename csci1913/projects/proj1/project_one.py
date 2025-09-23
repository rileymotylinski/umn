from math import floor,pow

# translating integer from board to the string version
int_to_stone = {
    0: " ",
    1: "●",
    2: "○"
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
    print("   " + " ".join([str(i%10) for i in range(len(board))]))
    for i in range(len(board) * 2):
        if i % 2 == 0:
            print("  ",end="")
            print("+-"*len(board[floor(i/2)]),end="")
            print("+")
        else:
            print(floor(i/2)%10, end=" ")
            for j in range(len(board[floor(i/2)])):
                print(f"|{int_to_stone[board[floor(i/2)][j]]}", end="")
            print("|")
    
    print("  ",end="")
    print("+-"*len(board[floor(i/2)]),end="")
    print("+")

get_board_as_string(generate_board(200))