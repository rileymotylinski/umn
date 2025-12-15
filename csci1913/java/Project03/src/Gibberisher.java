public class Gibberisher {
    private Trie<CharBag> segTrie;

    private int segLength;

    private int numLetterSamples;

    public Gibberisher(int segLength){
        this.segTrie = new Trie<CharBag>();

        this.numLetterSamples = 0;
        this.segLength = segLength;

    }

    /**
     * trains the model given an Array of strings
     * @param strings training strings
     */
    public void train(String[] strings){
        for(String s : strings) {
            // split word into letter samples
            LetterSample[] letterSamples = LetterSample.toSamples(s, this.segLength);

            for(LetterSample l : letterSamples) {
                // gets segment contained in current LetterSample
                String letterSampleString = l.getSegment();
                // finds the respective CharBag stored in the node that has letterSampleString as its node data
                CharBag cb = segTrie.get(letterSampleString);
                // if the CharBag DNE
                if (cb == null) {
                    this.segTrie.put(letterSampleString,new CharBag()); // this line is a problem
                    // now the CharBag will now exist
                    cb = segTrie.get(letterSampleString);
                }
                // adding the character in the letter segment to add to the distribution of the CharBag
                cb.add(l.getNextLetter());

                // counting number of samples parsed
                this.numLetterSamples += 1;



            }
        }
    }

    public int getSampleCount() {
        return this.numLetterSamples;
    }
    // returns the last n characters of s i.e. getLastN("scientist",2) -> "st" or getLastN("dog", 4) -> "dog"

    /**
     * returns the last N characters of a string, or the string if n >= s.length()
     * @param s sample string
     * @param n how many characters to get
     * @return substring of the last n characters
     */
    private String getLastN(String s, int n) {
        if (s.length() <= n) {
            return s;
        }
        return s.substring(s.length()-n);
    }

    /**
     * generates a random word based on training data in segTrie
     * @return randomly generated string
     */
    public String generate() {
        // bootstrapping word generation
        char ch = segTrie.get("").getRandomChar();
        String word = "" + ch;
        CharBag sample = segTrie.get(word);

        // can only generate works up to seg length
        while(ch != '.' && sample != null) {
            // finding the right CharBag with the parent string of the last SegLength letters of word
            sample = segTrie.get(getLastN(word,segLength));
            ch = sample.getRandomChar();
            // checking if we are adding a period; don't want those in the final string. Loop will break after this
            if (ch != '.') {
                word += ch;
            }

        }

        return word;
    }

}
