from math import factorial

def factorial(n):
    base = 1

    if n == 0:
        return base 
    
    for i in range(2,n+1):
        base = base * i
    return base 

base = 1

base *= n for n in range(1,5)

print(base)