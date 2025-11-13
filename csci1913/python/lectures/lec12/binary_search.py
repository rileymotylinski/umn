def binary_search(l,target,low,high):
    mid = (high + low) // 2
    # Base Cases
    # worst case
    if high < low:
        return -1
    # Not really a base case, but useful to have
    if l[mid] == target:
        return mid
    
    # Recursive Cases
    if target < l[mid]:
        return binary_search(l,target,low,mid-1)
    else:
        return binary_search(l,target,mid+1,high)

l = [1,2,3,4]

print(binary_search(l,4,0,len(l) - 1))
