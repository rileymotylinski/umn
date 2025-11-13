# nim

# requirements
1. `nim.py`- required, you write
2. `nim_tester.py` - requireed, provided
3. `play_num.py`- optional, provided

## rules of game
- tokens
    - organized into rows
- during turn:
    1. player removes token(s) (1-3)
        - can't take more than what is available in the row
    2. players alternate
other player must take the last token
- check for how many tokesn are left
    - if == 1, then the player whos turn it is loses


## required functions
`create_game_state(size,token_max)`
`is_valid_move(game_state, row, takes)`
`update(game_state, row, takes)`
`draw_game_state(game_state)`
`is_over(game_state)`

