# more swpas, very expensive

def bubble_sort(l):
    for i in range(len(l)):
        for j in range(len(l) - 1 - i):
            if l[j] > l[j+1]:
                l[j],l[j+1] = l[j+1],l[j]


l = [4,3,2,1]
bubble_sort(l)
print(l)