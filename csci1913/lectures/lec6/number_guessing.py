import random

MIN = 0
MAX = 100

n = random.randint(MIN,MAX)
guess = int(input("Guess a number: "))

while guess != n:
    if guess < n: 
        print("too low")     
    else:
        print("too high")
    guess = int(input("Guess a number: "))

print("you got it!")

    