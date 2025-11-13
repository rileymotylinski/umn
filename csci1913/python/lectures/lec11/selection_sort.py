l = [27,15,7,0,1,4]
def selection_sort(l):
    # don't need to check last index bc automatically sorted
    for i in range(len(l)-1):
        min = i
        # finding minimum
        for j in range(i,len(l)):
            if l[j] < l[min]:
                min = j
        # swapping i and index of minimum
        temp = l[i]
        l[i] = l[min]
        l[min] = temp


d ={
    "apples" : 3,
    "oranges" : 5,
    "pineapple" : 2
}

max = 0
max_word = ""

for key in d:
    if d[key] > max:
        max_word = key
        max = d[key]
print(max_word)
