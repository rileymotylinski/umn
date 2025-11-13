public class Hand {
    private Card[] h;
    private Deck d;
    private int size;

    public Hand(Deck deck, int size){
        this.h = new Card[size];
        this.d = deck;
        this.size = size;
        for (int i = 0; i < size; i++) {
            this.h[i] = deck.draw();
        }
    }

    public int getSize(){
        return this.size;
    }
    public Card[] getHand() {
        return this.h;
    }

    /**
     * gets a card at a given position in the hand
     * @param i index of the card
     * @return card if i is a valid index, otherwise the first card in the hand.
     */
    public Card get(int i) {
        if ( i >= this.size || i < 0) {
            System.out.println("Invalid hand index!");
            return this.h[0];
        }
        return this.h[i];
    }

    /**
     * removes a given card from hand
     * @param card card to be removed
     * @return try if card was found & removed, false otherwise.
     */
    public boolean remove(Card card){
        for (int i = 0; i < this.h.length; i++){
            // finding the given card in hand
            if (this.h[i].equals(card)) {
                // replacing with new card
                h[i] = this.d.draw();
                return true;
            }
        }
        return false;
    }

    /**
     * user friendly version of a hand
     * @return string of the format Ace of Spades, Two of Spades, etc.
     */
    @Override
    public String toString() {
        String s = "";
        // concatenating toString for each card in hand
        for (Card c : this.h) {
            s = s.concat(c.toString() + ", ");
        }
        return s;
    }
}
