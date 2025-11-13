public class GameScore implements Comparable<GameScore> {
    private double score;
    private String name;
    private boolean isHardMode;

    public GameScore(String name, double score, boolean hardMode){
        this.name = name;
        this.score = score;
        this.isHardMode = hardMode;
    }

    public String getName(){
        return this.name;
    }

    public double getScore() {
        return this.score;
    }

    public boolean isHardMode() {
        return this.isHardMode;
    }

    public String toString() {
        String score = name + " " + this.score;

        if(this.isHardMode){
            score += "*";
        }
        return score;
    }

    /**
     * determines if thisg ame score is equal to o. Scores are equal if the name, integer value,
     * and difficulty played on are all the same
     * @param o object to be compared to
     * @return true if equal, false otherwise
     */
    public boolean equals(Object o){
        if(! (o instanceof GameScore score1)){
            return false;
        }

        return score1.getName().equals(this.name)
                && score1.getScore() == this.score
                && score1.isHardMode() == this.isHardMode;
    }

    /**
     * Determines the bigger score. A score is bigger by default if it is on hard mode and the other isn't,
     * otherwise integer scores are compared directly
     * @param o the object to be compared.
     * @return 1 if this is bigger, -1 if o is bigger, 0 if they are equal
     */
    public int compareTo(GameScore o) {
        // if this is on hardmode and o is not OR this is bigger integer score and they are on the same difficulty
        if (this.isHardMode && !o.isHardMode() || (this.score > o.getScore() && this.isHardMode == o.isHardMode())){
            return 1;
        // opposite off above comment
        } else if (!this.isHardMode && o.isHardMode() || (this.score < o.getScore() && this.isHardMode == o.isHardMode())) {
            return -1;
        } else {
            // equal
            return 0;
        }
    }
}
