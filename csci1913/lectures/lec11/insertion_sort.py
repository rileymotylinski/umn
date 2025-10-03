def insertion_sort(l):
    for i in range(len(l)):
        j = i
        sorted = False
        while j > 0 and not sorted:
            if l[j] < l[j-1]:
                l[j],l[j-1] = l[j-1],l[j]
            else:
                sorted = True
            j -= 1

l = [2,65,7,2,1,1]
insertion_sort(l)
print(l)