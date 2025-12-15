public class SpellChecker {
    // if a word is in the dictionary
    // use hash table
    // takes a string as an input and returns na integer index for an array

    private String[] words;
    private int size = 10;

    public SpellChecker(String[] words) {
        this.words = new String[size];
        for (String word : words) {
            this.put(word);

        }
    }

    public int hash(String s) {
        int hash_code = 0;
        for (char c : s.toCharArray()) {
            hash_code += (int) c;
        }
    }

    public void resize() {

    }



    public void put(String s) {
        int h = hash(s) % 10;
        if (this.words[h] == null) {
            this.words[h] = s;
        } else {
            while (h < size && this.words[h] != null) {
                h += 1;
            }

            if (this.words[h] != null) {
                resize();
                put(s);
            } else {
                this.words[h] = s;
            }


        }
    }

    public int get(String s) {
        ;
    }
}
