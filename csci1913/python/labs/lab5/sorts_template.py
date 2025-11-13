'''
Lab 5, list partners here!
NAME HERE
NAME HERE
NAME HERE
'''


# For other python projects the style checker checks for lines of
# length 79. Because there is more writing to be done in this lab,
# that restriction has been relaxed to 120 characters

# LAB5 has a substantial written Q&A component as well. You answer
# these questions by updating the multi-line strings below to indicate
# your answer. It's a bit hokey, but it works.

# Question 1: Which image file you submitted covers which analysis case?
Answer1 = """
Replace With Answer
"""

# Question 2: For each algorithm, explain how you see it behaving in
# your images. If the algorithm's behavior differed case-by-case say
# this and explain how it behaved in each case.

Answer2_insertion = """
Replace With Answer
"""

Answer2_selection = """
Replace With Answer
"""

Answer2_merge = """
Replace With Answer
"""


# Question 3: For each algorithm, What is the theoretical expectation.
# I.E. what is the expected big-O runtime behavior. If the algorithm's
# expected behavior differs case-by-case say this and explain how it
# is expected to behave case-by-case. (You should be able to find this
# information in the textbook. If not we will discuss this in class)

Answer3_insertion = """
Replace With Answer
"""

Answer3_selection = """
Replace With Answer
"""

Answer3_merge = """
Replace With Answer
"""


# Question 4: For each algorithm, How did the observed behavior match
# the theoretical behavior? Again, if your answer differs case by
# case, say that here and explain your findings for each case.

Answer4_insertion = """
Replace With Answer
"""

Answer4_selection = """
Replace With Answer
"""

Answer4_merge = """
Replace With Answer
"""


# Question 5: Merge sort is theoretically the fastest algorithm, are there
# cases where another algorithm might be faster?

Answer5 = """
Replace With Answer
"""


# Question 6: If you didn't know the order of data you might want to sort,
# what algorithm might you use to sort it, and why?

Answer6 = """
Replace With Answer
"""


# Selection, Insertion, and Merge sorts -- taken from ZyBooks. Not too
# different, its still the same algorithm, they just did it using less
# memory than I did (Which leads to a slightly harder to understand
# piece of code)


def selection_sort(lst):
    """Sort the list lst in-place"""
    for i in range(len(lst) - 1):
        # Find index of smallest remaining element
        index_smallest = i
        for j in range(i + 1, len(lst)):
            if lst[j] < lst[index_smallest]:
                index_smallest = j

        # Swap lst[i] and lst[index_smallest]
        lst[i], lst[index_smallest] = lst[index_smallest], lst[i]


def insertion_sort(lst):
    """Sort the list lst in-place"""
    for i in range(1, len(lst)):
        j = i
        # insert lst[i] into sorted part
        # stopping once lst[i] in correct position

        # KLUVER NOTE - PLEASE READ - so this line is a bit tricky.
        #               Technically, if j > 0 then lst would not
        #               be compared to make things easier you can
        #               assume that every time the list condition is
        #               checked one array element comparison occurs.
        #               That is -- you can ignore the short-circuit
        #               evaluation of the logical and in this counting
        #               problem.
        while j > 0 and lst[j] < lst[j - 1]:
            # swap lst[j] and lst[j - 1]
            lst[j], lst[j-1] = lst[j-1], lst[j]
            j -= 1


def merge(lst, i, j, k):
    """Given two sorted sub-lists create one sorted list.

    This is
    done in-place, meaning we are given one list and expected to
    modify the list to be sorted.  Furthermore, this operates on
    "sub-lists" (a specific range of the list) The list named lst
    may contain other types of data than just numbers the variables i,
    j, and k are all indices into the lst list so the part of the
    list to be sorted is from position i to k (inclusive) with i to j
    being one sorted list, and j+1 to k being another.
    """
    merged_size = k - i + 1  #  Size of merged partition
    merged_lst = []  #  Temporary list for merged lst
    for _ in range(merged_size):
        merged_lst.append(0)

    merge_pos = 0  #  Position to insert merged lst

    left_pos = i  #  Initialize left partition position
    right_pos = j + 1  #  Initialize right partition position

    #  Add smallest element from left or right partition to merged lst
    while left_pos <= j and right_pos <= k:
        if lst[left_pos] < lst[right_pos]:
            merged_lst[merge_pos] = lst[left_pos]
            left_pos = left_pos + 1
        else:
            merged_lst[merge_pos] = lst[right_pos]
            right_pos = right_pos + 1
        merge_pos = merge_pos + 1

    #  If left partition is not empty, add remaining elements to merged lst
    while left_pos <= j:
        merged_lst[merge_pos] = lst[left_pos]
        left_pos = left_pos + 1
        merge_pos = merge_pos + 1

    #  If right partition is not empty, add remaining elements to merged lst
    while right_pos <= k:
        merged_lst[merge_pos] = lst[right_pos]
        right_pos = right_pos + 1
        merge_pos = merge_pos + 1

    #  Copy merge lst back to lst
    merge_pos = 0
    while merge_pos < merged_size:
        lst[i + merge_pos] = merged_lst[merge_pos]
        merge_pos = merge_pos + 1


def merge_sort_recursive(lst, i, k):
    """Sort the sub-list in lst from position i to k (inclusive)"""
    if i < k:
        j = (i + k) // 2  #  Find the midpoint in the partition

        #  Recursively sort left and right partitions
        # KLUVER NOTE - PLEASE READ - you should think about these two function calls as returning a count of
        #     comparisons. Naturally the comparisons done by those function-calls will count against this function-call.
        #     make sure you're not ignoring the return values on the following two lines.
        merge_sort_recursive(lst, i, j)
        merge_sort_recursive(lst, j + 1, k)

        #  Merge left and right partition in sorted order
        merge(lst, i, j, k)


def merge_sort(lst):
    """Sort a list (lst)

    This function is added on-top of the textbook's code to simply start the recursive process with the
    appropriate parameters. This also gives us a consistent sorting interface over the three sorts.
    """
    merge_sort_recursive(lst, 0, len(lst) - 1)
