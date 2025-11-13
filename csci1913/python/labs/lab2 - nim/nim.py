"""
Author: RIley Motylinski
Class: CSCi 1913
"""

def create_game_state(size: int,token_max: int) -> list:
    '''
    creates a nim game board w/ appropriate number of tokens

    Args:
    size      -- int -- how many rows are in the game board
    token_max -- int -- max number of tokens to be reached

    Returns:
    list -- created game board of sizexsize size

    '''

    board = []
    
    # number of rows is [1,size], inclusive
    for i in range(1,size+1):
        # adding ascending number of tokens
        if i < token_max:
            board.append(i)

        # if i reaches token_max before size, then 
        # begin appending max number of tokens
        else:
            board.append(token_max)
    return board

def is_valid_move(game_state: list, row: str, takes: str) -> bool:
    '''
    verifies user input as a move that can be made

    Args:

    game_state -- list -- current board
    row        -- str --  the row given by the user, starts indexing at 1
    takes      -- str --  the number of tokens to be taken from game_state[row]

    Returns:
    boolean - if the supplied move is valid, true, else false
    '''

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
    '''
    returns a new copy of the game_state list with the "takes" subtracted at game_state[row].
    inputs are assumed to be valid moves.

    Args:

    game_state -- list -- current board
    row        -- str --  the row given by the user, starts indexing at 0
    takes      -- str --  the number of tokens to be taken from game_state[row]

    Returns:
    list -- updated gamestate
    '''
    new_list = game_state.copy()
    new_list[row] -= takes
    
    return new_list

def draw_game_state(game_state: list) -> None:

    '''
    draws a user friendly version of the game state.

    Args:
    game_state -- list -- current board

    Returns:
    None

    eg. draw_game_state([5,4,3,4,1,0,0,9,1]) ->
    ====================
    1 #####
    2 ####
    3 ###
    4 ####
    5 #
    6 
    7 
    8 #########
    9 #
    ====================
    '''

    print("="*20)
    for i in range(len(game_state)):
        print(str(i+1) + " " + ("#" * game_state[i]))
    print("="*20)

def is_over(game_state: list):
    '''
    draws a user friendly version of the game state.

    Args:
    game_state -- list -- current board

    Returns:
    None
    '''
    
    # any returns true if there is a true value in an iterable.
    # performing the inverse shows us there are no truth values left
    return not any(game_state)


if __name__ == "__main__":
    assert create_game_state(5,3) == [1,2,3,3,3]

