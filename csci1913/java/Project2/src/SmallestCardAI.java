public class SmallestCardAI extends AI {

    /**
     * Strategy is to get the smallest card in the hand.
     * @param hand starting hand
     * @param cardPile current games cardPile instance
     * @return
     */
    @Override
    public Card getPlay(Hand hand, CardPile cardPile) {
        if (hand.getSize() == 0) {
            return null;
        }

        Card smallestCard = hand.get(0);
        for (Card c : hand.getHand()) {
            // finding minimum card
            if (c.compareTo(smallestCard) < 0) {
                smallestCard = c;
            }
        }

        return smallestCard;
    }

    @Override
    public String toString() {
        return "Smallest Card AI";
    }

}
