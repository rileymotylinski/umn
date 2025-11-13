public class BiggestCardAI extends AI {

    /**
     * Strategy is to play biggest playable card
     * @param hand starting hand
     * @param cardPile current games cardPile instance
     * @return biggest (highest rank) playable card
     */
    public Card getPlay(Hand hand, CardPile cardPile) {
        // no playable cards
        if (hand.getSize() == 0) {
            return null;
        }

        Card biggestCard = hand.get(0);
        for (Card c : hand.getHand()) {
            // checking for biggest card in hand
            if (c.compareTo(biggestCard) > 0) {
                biggestCard = c;
            }
        }

        return biggestCard;
    }
    @Override
    public String toString() {
        return "Biggest Card AI";
    }
}
