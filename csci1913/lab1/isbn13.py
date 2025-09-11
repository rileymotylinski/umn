'''
Class: CSCI 1913  (010)
Name: Riley Motylinski
Lab Partners: Samir, Cardin
'''

# lowest multiple with 3 to add to a digit to reach the nearest ten. SEE: make_isbn13()
MIN_ADD = {
    0:0,
    1:3, 
    2:6,
    3:9,
    4:2,
    5:5,
    6:8,
    7:1,
    8:4, 
    9:7
}

def sum_digits(isbn: int) -> int:
    '''
    sums the even / odd digits of a given number, then applies the isbn summation formula.

    Args:
        isbn -- integer
    Returns:
        total -- integer
    '''
    isbn = str(isbn)
    odd_total = 0
    even_total = 0

    for i in range(len(isbn)):
        current_digit = int(isbn[i])

        # odd digit
        if i % 2 == 1:
            odd_total += current_digit
        # even digit
        elif i % 2 == 0:
            even_total += current_digit
    # summation formula for isbn digits
    # even / odd digits are switch around in formula 
    # because of indexing of the isbns vs. a string
    total = even_total + (3 * odd_total)
    
    return total

def check_isbn13(isbn: int) -> bool:
    '''
    verifys isbn given valid isbn criteria

    Args:
        isbn -- int
    Returns:
        boolean
    '''
    # isbn is negative
    if isbn < 0:
        return False
    # isbn has >13 digits
    if len(str(isbn)) > 13:
        return False
    # digits are not divisble by 10
    if sum_digits(isbn) % 10 != 0:
        return False
    return True

def make_isbn13(number: int) -> int:
    '''
    calculates the check digit given a <13 digit isbn

    Args:
        number -- integer
    Returns:
        integer
    '''
    # isbn matches minimum criteria to be processed
    if len(str(number)) <= 13 and number >= 0:
        isbn_total = sum_digits(number)  
       
        # number is already divisble by 10, so no need to add anything other than 0
        if isbn_total % 10 == 0:
            check_digit = 0
        elif len(str(number)) % 2 == 0:
             # need to add number here to get number to "nearest 10"
            nearest_isbn_ten = isbn_total + (10 - (isbn_total % 10))
            # this will always be true only for isbns with an
            # even number of digits
            check_digit = nearest_isbn_ten - isbn_total
                 
        # Otherwise, if an isbn has an odd number of digits, we have to add the lowest multiple with 
        # 3 that will result in "0" as the last digit

        # I have chosen to do this via a hardcoded dictionary for three reasons:
        # 1) efficiency: I'm sure there is some pattern to the sequence of numbers, however
        #    I was unable to identify one and it is faster (marginally) to have the values
        #    instantly available rather than generate them at runtime
        # 2) finite space: There are only 10 numbers that we need to know the key value for,
        #    so, realistically, it isn't a big impact on the size or efficiency of the program 
        #    to store these numbers. Had it been a more significant amount of data I would have
        #    used loops to manually check or found an alternate approach
        # 3) Avoiding loops: loops were an obvious choice to brute force the solution, however
        #    running a loop against a known pattern an indefinite amount of times would be wasteful.

        else:
            check_digit = MIN_ADD[isbn_total%10]
    
        return int(str(number) + str(check_digit))
    else:
        return -1
    

