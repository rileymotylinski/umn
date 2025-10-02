# Author: Riley Motylinski
# Class: CSCI 1913

def is_sorted(pricebook):
    '''
    Purpose: determines if a pricebook is sorted based on the name field

    Arguments:
    pricebook - tuple(float, string) - list of price, item keys

    Returns:
    boolean - true if sorted, false otherwise
    '''
    # any list without items is sorted
    if len(pricebook) == 0:
        return True
    
    for i in range(len(pricebook)-1):
        # if any item is less than the item that preceeds it, then the list is not sorted
        if pricebook[i][1] > pricebook [i+1][1]:
            return False
    # default case
    return True

def price_average(pricebook):
    '''
    Purpose: Averages all the prices fields in a pricebook

    Arguments: 
    pricebook - tuple(float, string) - list of price, item keys

    Returns:
    float - average of all price values in a pricebook
    '''
    # a list without entries has an average of 0
    if len(pricebook) == 0:
        return 0.0
    
    total = 0
    for item in pricebook:
        # summing every price in pricebook
        total += item[0]
    # average = sum(pricebook) / len(pricebook)
    return total / len(pricebook)

def unsorted_get(pricebook,name):
    '''
    Purpose: performs linear search to find the matching name field in an unsorted pricebook

    Arguments: 
    pricebook - tuple(float, string) - list of price, item keys
    name - string - name of the item to be searched for

    Returns:
    float | None - price field of corresponding name tuple or None if the entry does not exist
    '''
    # linear search
    for item in pricebook:
        # if matched name, return price
        if item[1] == name:
            return item[0]
    return None

def unsorted_put(pricebook,name,price):
    '''
    Purpose: either updates the price if a pricebook entry if it already exists, or appends it to the pricebook in an unsorted manner

    Arguments: 
    pricebook - tuple(float, string) - list of price, item keys
    name - string - name of pricebook entry to update/insert
    price - float - price of pricebook entry

    Returns:
    None - this function changeds the pricebook object in place
    '''
    # initializing entry tuple for clarity
    entry = (price, name)

    # if the item exists in the pricebook
    if unsorted_get(pricebook,name) != None:
        # update entry where there is a mtach in name
        for i in range(len(pricebook)):
            if pricebook[i][1] == name:
                pricebook[i] = entry
    else:
        # if the item doesn't already exist, then it suffices to append the entry
        pricebook.append(entry)

def sorted_get(pricebook, name):
    '''
    Purpose: locates the pricebook entry in a sorted pricebook

    Arguments: 
    pricebook - tuple(float, string) - list of price, item keys
    name - string - name of pricebook entry to get

    Returns:
    float | None - either the price of the entry or None if the entry does not exist
    '''
    # binary search variables
    high = len(pricebook) - 1
    low = 0
    # binary search, but using strings instead of integers for search comparisons
    while low <= high:
        # halve the search window
        mid = (low + high) // 2
        # name is left half of list
        if pricebook[mid][1] > name:
            high = mid - 1
        # name is in right half of list
        elif pricebook[mid][1] < name:
            low = mid + 1
        else:
            # match of name, so reaturn match
            return pricebook[mid][0]
    # unable to find the entry in pricebook
    return None

def sorted_put(pricebook: list, name, price):
    '''
    Purpose: inserts an entry into its sorted position

    Arguments: 
    pricebook - tuple(float, string) - list of price, item keys. Assumed to be sorted.
    name - string - name of pricebook entry to get

    Returns:
    None - this function changes the pricebook object in place
    '''
    # initialize enty for clarit
    entry = (price, name)

    # can append to empty list and a list wiht only one item is already sorted
    if len(pricebook) == 0:
        pricebook.append(entry)
        return None

    # if name exists in pricebook
    # O(n)
    if sorted_get(pricebook,name) == None:
        # if the name value is the greatest in the entire list
        if name < pricebook[0][1]:
            pricebook.insert(0,entry)
            return None
        
        # if the name value is the least in the entire list
        elif name > pricebook[len(pricebook) - 1][1]:
            pricebook.append(entry)
            return None
        
       # initializing variables for swap
        pricebook.append(entry)
        i = len(pricebook) - 1

        # O(n)
        while i >= 1:
            # swap the smaller value downwards
            if pricebook[i][1] < pricebook[i-1][1]:
                temp = pricebook[i]
                pricebook[i] = pricebook[i-1]
                pricebook[i-1] = temp
            # if entry is in the correct position
            else:
                # can return here because the rest of the list is already sorted
                return None
            i -= 1
                
    else:
        # perform linear search O(n) to update entr
        for i in range(len(pricebook)):
            if pricebook[i][1] == name:
                pricebook[i] = entry
    
    return None