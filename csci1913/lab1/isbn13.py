'''
Name: Riley Motylinski
Lab Partners: Samir, Cardin
'''

test_isbn = 978030640615 # last digit should be 7

MIN_ADD = {
    0:0,
    1:9, 
    2:18,
    3:27,
    4:6,
    5:15,
    6:24,
    7:3,
    8:12, 
    9:21
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
    calculates the check digit given a 12-digit isbn

    Args:
        number -- integer
    Returns:
        integer
    '''
    
    if len(str(number)) <= 13 and number >= 0:
        total = sum_digits(number)
      
        

        print(f"{number} : {total}")
        # need to add number here to get number to "nearest 10"
        nearest_ten = total + (10 - (total % 10)) # not my favorite


    
        if len(str(number)) % 2 == 0:
            # this will always be true for isbns with an
            # even number of digits
            check_digit = nearest_ten - total

            # Just take the points now...
            # I know it's an issue with my nearest_ten formula, but
            # I don't know why
            if check_digit == 10:
                check_digit = 0
            
        # if an isbn has an odd number of 
        else:
            check_digit = MIN_ADD[total%10] // 3
    
        return int(str(number) + str(check_digit))
    else:
        return -1
    

