"""
Author: RIley Motylinski
Class: CSCi 1913
"""

def create_game_state(size: int,token_max: int) -> list:
    '''
    creates a nim game board w/ appropriate number of tokens

    Args:
    size -- int -- how many rows are in the game board
    token_max -- int -- max number of tokens to be reached

    Returns:
    list -- created game board

    '''

    if size == 0:
        return []

    board = []
    
    # number of rows is [1,size], inclusive
    for i in range(1,size+1):
        if i < token_max:
            board.append(i)
        # if we have reached token_max before size, then 
        # begin appending max number of tokens
        else:
            board.append(token_max)
    return board

def is_valid_move(game_state: list, row: str, takes: str) -> bool:
    # checks if the number of tokens at a certain row is 
    # greater than the number of tokens the player wants to take

    # validating user input as integers
    if not row.isdigit() or not takes.isdigit():
        return False
    
    # now safe to convert to integers
    takes = int(takes)
    # transform to zero-based indexing 
    row = int(row) - 1

    if row >= len(game_state) or row < 0:
        return False
    
    if takes < 1 or takes > 3 or takes > game_state[row]:
        return False

    return True

def update(game_state: list, row: int, takes: int) -> list:
    # does not need to validate inputs
    # creates new list
    # row variable is 0 indexed in this case

    new_list = game_state.copy()

    new_list[row] -= takes
    
    return new_list
def draw_game_state(game_state: list) -> None:
    print("="*20)
    for i in range(len(game_state)):
        print(str(i+1) + " " + ("#" * game_state[i]))
    print("="*20)

def is_over(game_state: list):
    return not any(game_state)


if __name__ == "__main__":
    assert create_game_state(5,3) == [1,2,3,3,3]