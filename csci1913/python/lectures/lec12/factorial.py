def factorial(n):
    # base case(s)
    if n == 1 or n == 0:
        return 1
    # recursive call(s)
    return n * factorial(n-1)