def linear_search(l, n):
    for i in range(len(l)):
        if l[i] == n:
            return i
    return -1