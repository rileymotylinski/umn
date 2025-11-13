public class Card {
    private int rank;
    private int suit;

    final public static String[] RANK_NAMES = {
            "Ace",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            "Ten",
            "Jack",
            "Queen",
            "King"
    };

    final public static String[] SUIT_NAMES = {
            "Spades",
            "Hearts",
            "Clubs",
            "Diamonds"

    };


    /**
     * validates incoming card date. If it is invalid, it becomes the Ace of Spades.
     * @param rank rank for card
     * @param suit suit for card
     */
    public Card(int rank, int suit) {
        if (rank <= 0 || rank >= 14 || suit <= 0 || suit >= 5) {

            System.out.println("Invalid Card");

            // setting to ace of spades
            rank = 1;
            suit = 1;
        }

        this.rank = rank;
        this.suit = suit;

    }

    public int getRankNum() {
        return this.rank;
    }

    public String getRankName() {
        return RANK_NAMES[this.rank-1];
    }

    public String getSuitName() {
        return SUIT_NAMES[this.suit - 1];
    }

    @Override
    public String toString() {
        return this.getRankName() + " of " + this.getSuitName();
    }

    /**
     * validates whether a cards rank and suit are equal.
     * @param obj
     * @return true if they are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        // check if they are the same object in-memory
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Card)) {
            return false;
        }
        // rank && suit are equal
        return ((Card) obj).rank == this.rank && ((Card) obj).suit == this.suit;
    }

    /**
     * comparing one card to another. Negative if less than compared card. Positive otherwise.
     * @param c card to be compared to
     * @return the difference in a cards rank
     */
    public int compareTo(Card c) {
        return this.rank - c.rank;
    }

}
