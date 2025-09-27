def binary_search(l, n):
    low = 0
    high = len(l) - 1

    while low <= high:
        mid = (low + high) // 2

        if n < l[mid]:
            high = mid - 1
        elif n > l[mid]:
            low = mid + 1
        else:
            return mid
    return -1
