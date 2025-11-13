def commonality(*animals):
    
    if len(animals) == 0:
        return set()
    
    common = set(animals[0])

    for l in animals:
        common.intersection(set(l))
    return common
    
