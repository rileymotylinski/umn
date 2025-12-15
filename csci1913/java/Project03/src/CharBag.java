import java.lang.Math;

public class CharBag {
    private int[] count;
    // cumulative distribution function; stores ranges of probability for random sampling
    private double[] cdf;
    // unicode for 'a'
    final private int UNICODE_OFFSET = 97;
    // unicode for '.'
    final private int STOP_CHARACTER = 46;


    private int adds;
    private int removes;

    public CharBag () {
        this.count = new int[27];
        this.cdf = new double[27];

        updateCdf();

        this.adds = 0;
        this.removes = 0;
    }

    /**
     * returns the index for a character. Hash uses intrinsic unicode/ASCII value
     * @param c character to find index for
     * @return index in our count
     */
    public int hash(char c) {
        int charUnicode = (int) Character.toLowerCase(c);

        return charUnicode >= UNICODE_OFFSET && charUnicode <= UNICODE_OFFSET + 26
                ? charUnicode - UNICODE_OFFSET // get letter index
                : 26; // stop character count is stored at the end of the array
    }

    /**
     * translates an index into a character
     * @param i index of character
     * @return character at the index
     */
    public char unhash(int i) {
        if (i > 25 || i < 0) {
            return (char) STOP_CHARACTER; // if not in charbag, return stop character
        }
        // casting to character
        return (char) (i + UNICODE_OFFSET);
    }

    // O(n)

    /**
     * updates the distribution representing the probability of nextLetter
     */
    private void updateCdf() {
        double total = 0;
        int totalChars = this.getSize();

        // need to reset all values to 0 before finding distribution
        this.cdf = new double[27];

        for (int i = 0; i < this.count.length; i++){

            if(count[i] != 0){
                // normalization ( 0 <= P(character) <= 1 )
                double probabilityLetter = (double) count[i] / totalChars;
                total += probabilityLetter;
                this.cdf[i] += total;

            }

        }
    }

    /**
     * adds a character to count. Does NOT update distribution.
     * @param c character to add
     */
    public void add (char c) {
        // updating at hash; everything is default to 0 not null
        count[hash(Character.toLowerCase(c))] += 1;
        // store adds for O(1) size calculation
        this.adds += 1;
    }

    /**
     * removes a character if it exists
     * @param c character to remove
     */
    public void remove(char c) {
        int charIndex = hash(Character.toLowerCase(c));
        // only remove if there actually is anything to remove
        if(count[charIndex] > 0) {
            count[charIndex] -= 1;
            this.removes += 1;
        }

    }

    /**
     * gets count of a character in the CharBag
     * @param c character to get count of
     * @return count of character
     */
    public int getCount(char c) {
        return count[hash(Character.toLowerCase(c))];
    }

    /**
     * gets size of the character bag, defined as number of characters in the CharBag
     * @return number of characters is CharBag
     */
    public int getSize() {
        int total = this.adds - this.removes;
        return Math.max(total, 0);

    }

    /**
     * user friendly version of CharBag for debugging
     * @return e.g. CharBag{a : 0, b: 1,..., z: 5, . : 2}
     */
    public String toString() {
        String s = "CharBag{";
        for(int i = 0; i < this.count.length-1; i++) {
            s += (unhash(i) + ":" + count[i] + ", ");
        }

        s += unhash(26) + ":" + count[26] + "}";
        return s;
    }

    /**
     * Returns a random character from the character distribution
     * @return rangdom character from current charbag
     */
    public char getRandomChar() {
        // O(n) complexity right now - how to get O(1)?
        // make sure distribution is up to date with current charabag
        updateCdf();

        // random float choice; this is why we normalize in updateCdf()
        double choice = Math.random();

        // if choice is the first character
        if (choice <= this.cdf[0]){
            return unhash(0);
        }

        // linear search for cdf[i-1] <= choice < cdf[i]
        for(int i = 1; i < this.cdf.length - 1; i++) {
            if (choice >= this.cdf[i - 1] && choice < this.cdf[i]){
                // returns unhashed version of character
                return unhash(i);
            }
        }
        // choice was stop character
        return (char) STOP_CHARACTER;
    }



}
