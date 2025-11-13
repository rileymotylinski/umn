def power(n, p):
    if p == 0:
        return 1
  
    
    return n * power(n,p-1)


# T(n) = T(n - 1) + T(n -1) + 1


# 2 ^ 3
# 2 * 2^3
# 2 * 2 * 2
# redefining problem in terms of a smaller problem that is the same as the original problem

print(power(3,3))