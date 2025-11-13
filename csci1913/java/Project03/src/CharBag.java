import java.util.Random;

public class CharBag {
    // stop character of "."
    // TODO : USE STATIC VARIABLE TO LETTER SAMPLER CLASS
    private final int STOP_CHARACTER_UNICODE = 46;
    private final int UNICODE_OFFSET = 97;

    private int[] count = new int[27];
    private double[][] distribution;

    private boolean updated = false;

    private int removes = 0;

    private boolean inAlphabet(int unicode) {
        // >= a, <= z
        return unicode >= UNICODE_OFFSET && unicode <= 122;
    }
    private boolean inAlphabet(char c) {
        return inAlphabet((int) c);
    }

    // i'd rather just get this on the fly in O(27) or O(1)
    private int getLength() {
        int total = 0;
        for (int i = 0; i<this.count.length;i++){
            if (this.count[i] > 0){
                total += 1;
            }
        }
        return total;
    }

    private void updateDistribution() {
        this.distribution = new double[this.getLength()][2];
        int totalCharacters = this.sumCharBag();

        // divide each non-updated number by 1 + previous length
        //
        int distributionIndex = 0;
        double sum = 0;
        for (int i = 0; i < this.count.length; i++){
            if (this.count[i] > 0) {
                double probability = (double) this.count[i]/totalCharacters;

                // setting next probability interval
                // guarantees montone
                this.distribution[distributionIndex][0] = sum;
                sum += probability;
                this.distribution[distributionIndex][1] = toUnicode(indexToChar(this.count[i]));
                distributionIndex += 1;

            }
        }
    }
    private int toUnicode(char c){
        int unicodeNumber = (int) c;

        if (inAlphabet(unicodeNumber)) {
            return unicodeNumber;
        }
        return STOP_CHARACTER_UNICODE;
    }

    private int charToIndex(char c){
        int unicodeNumber = toUnicode(c);
        // offset of a letter
        return unicodeNumber != STOP_CHARACTER_UNICODE ? unicodeNumber - UNICODE_OFFSET : 27;
    }

    private char indexToChar(int i) {
        return i != 27 ? (char) (i + UNICODE_OFFSET) : (char) STOP_CHARACTER_UNICODE;
    }

    private int sumCharBag(){
        int j = 0;

        for (int i = 0; i < this.count.length; i++){
            j += count[i];
        }
        return j;
    }

    public void add(char c) {
        this.count[charToIndex(Character.toLowerCase(c))] += 1;
        this.updated = true;
    }

    public void remove(char c) {
        c = Character.toLowerCase(c);
        int currentCount = this.count[charToIndex(c)];
        this.updated = true;
        if (currentCount > 0) {
            this.count[charToIndex(c)] -= 1;
            this.removes += 1;
        }

    }

    public int getCount(char c) {
        c = Character.toLowerCase(c);

        return this.count[charToIndex(c)];
    }

    public int getSize(){
        return sumCharBag() - this.removes;
    }

    // O(2n) as of right now, is there a way to make the update distribution conditional?
    public char getRandomChar() {

        // Average case should be better. Avoids unnecessary updates. Worst case is still O(2n) or O(n)
        if(this.updated) {
            // only need to update distribution when you call getRandomChar
            updateDistribution();
            this.updated = false;
        }



        Random r = new Random();
        double choice = r.nextDouble();

        for (int i = 0; i < this.distribution.length; i++){
            if (choice > this.distribution[i][0]){
                return (char) this.distribution[i][1];
            }
        }
        return (char) STOP_CHARACTER_UNICODE;
    }





}
