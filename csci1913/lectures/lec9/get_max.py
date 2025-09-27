def get_max(*numbers):
    # if the length of the list == 0, return 0
    if len(numbers) == 0:
        return None
    
    # max is (optimally) the first element in array
    max = numbers[0]

    # iterate through list to find greatest number
    for number in numbers:
        if number > max:
            max = number

    return max


# best case : when len(numbers) == 0 , return None
# - is it worth sorting the list?
