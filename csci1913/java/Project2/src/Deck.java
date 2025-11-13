import java.util.Random;

public class Deck {
    private Card[] deck;
    private int drawn;

    public Deck() {
        this.deck = new Card[52];

        // iterating through every card in the deck
        for (int i = 0; i < this.deck.length;i++){
            // making valid rank/suit by adding 1
            int rank = (i % 13) + 1;
            int suit = (i % 4) + 1;

            deck[i] = new Card(rank,suit);
        }
    }

    public Card[] getDeck(){
        return this.deck;
    }

    /**
     * shuffles this.deck instance variable by iterating
     * through the deck once and swapping card at index
     * less than currentIndex
     */
    public void shuffle() {
        Random r = new Random();
        for (int i = deck.length - 1; i >= 1; i--){

            int randomIndex = r.nextInt(i);
            // swapping currentIndex and randomIndex
            Card temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
    }

    /**
     * draw card from current deck. If deck is empty, shuffle, then draw again.
     * @return drawn card
     */
    public Card draw() {
        if (!this.isEmpty()) {
            // subtract 1 so guarantee less than the last index
            Card c = deck[deck.length - 1 - drawn];
            drawn += 1;
            return c;
        } else {
            this.shuffle();
            // reset so we are drawing from the top of the deck
            this.drawn = 0;
            // just call the method again to get the new card
            return this.draw();
        }
    }

    public int cardsRemaining() {
        return this.deck.length - drawn;
    }

    public boolean isEmpty() {
        return this.drawn >= 52;
    }
}
