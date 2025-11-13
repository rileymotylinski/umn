'''
Original Authors: Daniel Kluver and Sam Fountain
Changes by: Adriana Picoral Fall 2025

Decription:
 Tests for required functions on lab 5

 Note -- the merge tests are intentionally duplicated.
 A common error leads in counting for this function leads to
         results that change under repeated testing.

'''


from sorts import *
import sorts

def do_test(output, expected):
    try:
        assert output == expected
        print(f"Expected {expected} matched output")
    except:
        print(f"The expected output was {expected} but {output} was output instead")

def check_answer(string):
    if "Replace With Answer" in string:
        print("Answer hasn't been changed")
    if len(string) < 10:
        print("Answer is too short")

if __name__ == "__main__":
    print("**** Beginning of insertion_sort ****")
    do_test(insertion_sort([1, 2, 3, 4, 5]), 4)
    do_test(insertion_sort([5, 4, 3, 2, 1]), 14)
    do_test(insertion_sort([1, 5, 3, 4, 2]),  9)
    do_test(insertion_sort([2, 7, 5, 6, 9, 3, 1, 0, 8, 4]), 34)
    print("**** End of insertion_sort ****\n")

    print("**** Beginning of selection_sort ****")
    do_test(selection_sort([1, 2, 3, 4, 5]), 10)
    do_test(selection_sort([5, 4, 3, 2, 1]), 10)
    do_test(selection_sort([1, 5, 3, 4, 2]), 10)
    do_test(selection_sort([2, 7, 5, 6, 9, 3, 1, 0, 8, 4]), 45)
    print("**** End of selection_sort ****\n")

    print("**** Beginning of merge_sort ****")
    do_test(merge_sort([1, 2, 3, 4, 5]),  7)
    do_test(merge_sort([5, 4, 3, 2, 1]), 5)
    do_test(merge_sort([1, 5, 3, 4, 2]), 8)
    do_test(merge_sort([2, 7, 5, 6, 9, 3, 1, 0, 8, 4]), 23)
    print("**** End of merge_sort ****\n")

    print("**** Beginning of merge ****")
    do_test(merge([1,2,3,4,5,6,7,8], 0, 4, 7), 5)
    do_test(merge([1,2,3,4,5,6,7,8], 0, 4, 7), 5)
    do_test(merge([9,1,5,3,6,-2], 1, 2, 4), 3)
    do_test(merge([9,1,5,3,6,-2], 1, 2, 4), 3)
    do_test(merge([2, 5, 6, 7, 9, 0, 1, 3, 4, 8], 0, 4, 9), 9)
    do_test(merge([2, 5, 6, 7, 9, 0, 1, 3, 4, 8], 0, 4, 9), 9)
    do_test(merge([1, 5, 6, 7, 8, 0, 2, 3, 4, 9], 0, 4, 9), 9)
    do_test(merge([1, 5, 6, 7, 8, 0, 2, 3, 4, 9], 0, 4, 9), 9)
    print("**** End of merge ****\n")

    # check that all questions are answered
    print("Checking answers")
    check_answer(sorts.Answer1)
    check_answer(sorts.Answer2_insertion)       
    check_answer(sorts.Answer2_selection)       
    check_answer(sorts.Answer2_merge)           
    check_answer(sorts.Answer3_insertion)      
    check_answer(sorts.Answer3_selection)      
    check_answer(sorts.Answer3_merge)            
    check_answer(sorts.Answer4_insertion)       
    check_answer(sorts.Answer4_selection)       
    check_answer(sorts.Answer4_merge)            
    check_answer(sorts.Answer6)                  
    check_answer(sorts.Answer5)                  



