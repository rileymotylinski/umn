public class AI {
    /**
     * Base AI class. Strategy is to pick random card
     * @param hand starting hand
     * @param cardPile current games cardPile instance
     * @return first playable card. Effectively random.
     */
    public Card getPlay(Hand hand, CardPile cardPile) {
        for (Card c : hand.getHand()) {
            if (cardPile.canPlay(c)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Random Card AI";
    }
}
