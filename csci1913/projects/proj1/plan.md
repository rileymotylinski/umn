# Kōnane

## Submission Requirements
- `project_one.py` as file name
- name @ top w/ docstring
- __1010/2025 @ 5pm__

## Setup Board
- 8x8 - black/white alternate across rows + columns
- each player randomly assigned color
    - One player removes two stones from the center (2x2 area, in the case of an 8x8 board)
    - black moves first

## Turns
- first player "jumps" black stone over white stone -> empty space
    - chain multiple jumps together
    - straight line. no diagonals
    - up/down/left/right
- alternates

## Ending game
- no moves = loss
- winner is always ast player to make a move

## Program Requirements
- assume rectangular board
- board; list of lists
- empty : 0
- black : 1
- white : 2
- move : `Tuple[Tuple[int,int], Tuple[int,int]]`
    - firast tuple is start, second tuple is end
    - in other words, `Tuple[start,end]`

### Functions
`generate_board(n: int) -> List[List[int]]`
- generates square board of nxn dimensions
- (0,0) = 1, alternates from there
- n <= 0 -> []

`get_board_as_string(board)`
cell:
"""
+-+
| |
+-+
"""

white:
"○"
black:
"●"

- row/columns should be numbered
    - 0 based indexing

`prep_board_human(board) -> None`
- prints board as a string
- prompss user to enter two row/column locations
- remove token at those two locations
    - location requirements
        - different colors
            - if not, reprompt
        - if the same color is picked twice the user should be re prompted
        both tokens must not be on the edge of the board
- Mutates board

`is_valid_move(board, move) -> bool`
- `true` if move is possible, `false` if move is not possible
- lots of checks?
    - jumping over alternate color
    - empty start end
    - prompting user is the moving user
    - move is within the bounds of the board
- move is tuple of tuples (start, end)
