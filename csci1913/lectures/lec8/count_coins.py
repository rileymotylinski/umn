
value_to_coin = {1: "pennies", 5: "nickels", 10:"dimes",25:"quarters"}
def count_coins(coins):
    coin_count = {"pennies": 0 , "nickels" : 0 , "dimes": 0,"quarters": 0}

    for coin_value in coins:
        if coin_value in value_to_coin:
            coin_count[value_to_coin[coin_value]] += 1
    return coin_count