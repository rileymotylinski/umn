def hex_to_rgb(hex_str):
    '''
        converts a hex string to its rgb values
        Args:
            hex_str: str --> always 7 characters
        Returns
            Tuple --> r,g,b values, respectively
    '''

    f = hex_str[1:3]
    s = hex_str[3:5]
    l = hex_str[5:7]

    return (int(f,16), int(s,16), int(l,16))

