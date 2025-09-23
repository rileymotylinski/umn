def commonality(*animals):
    if len(animals) <= 1:
        return set(animals)

    return set(animals[0]).union(commonality(animals[1:]))

print(commonality((['a', 'b', 'c', 'c'],)))

