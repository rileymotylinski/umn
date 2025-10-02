from selection_sort import *

def do_test(output, expected, sort):
    try:
        assert output == expected
        print(f"{sort.__name__} matched output and expected value:\n{expected}")
    except:
        print(f"The output {output} from {sort.__name__} was different from {expected}")

if __name__ == "__main__":
    sort = selection_sort # change this
    print(f"***** Beginning of {sort.__name__} testing *****")

    numbers = [39, 53, 93, 17, 58, 74, 94, 35, 99, 59]
    sort(numbers)
    expected = [17, 35, 39, 53, 58, 59, 74, 93, 94, 99]
    do_test(numbers, expected, sort)

    fruit = ["blackberry", "apple", "papaya",  "cantaloupe", "apricot",  "banana"]
    sort(fruit)
    expected = ['apple', 'apricot', 'banana', 'blackberry', 'cantaloupe', 'papaya']
    do_test(fruit, expected, sort)

    float_numbers = [40.59, 13.1, 2.22, 14.08, 12.96, 2.96, 16.11, 14.51, 76.55, 12.8, 1.4]
    sort(float_numbers)
    expected = [1.4, 2.22, 2.96, 12.8, 12.96, 13.1, 14.08, 14.51, 16.11, 40.59, 76.55]
    do_test(float_numbers, expected, sort)

    print(f"***** End of {sort.__name__} testing *****")
    