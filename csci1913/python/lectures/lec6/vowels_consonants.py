VOWELS = "aeiouAEIOU"

# divides up a string into its vowels and consonants
def vowels_consonants(s: str) -> tuple:
    '''
    returns the vowels and consants of a given string, s

    Args:
    s -- string -- string to be checked

    Returns:
    tuple(list, list) -- vowels, consonants
    '''
    vowels = []
    consonants = []

    for character in s:
        if character in VOWELS:
            vowels.append(character)
        else:
            consonants.append(character)
    return (vowels, consonants)

if __name__ == "__main__":
    assert vowels_consonants("") == ([],[])

