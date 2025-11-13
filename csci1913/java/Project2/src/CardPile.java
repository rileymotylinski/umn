public class CardPile {
    private Card topCard;
    private int cardsPlayed;

    public CardPile(Card topCard) {
        this.topCard = topCard;
        this.cardsPlayed = 1;
    }

    /**
     * checks if a card is valid play. A valid play is a card that
     * is greater than top card or equal to top cards suit
     * @param card card to check if it can be played
     * @return true if paramter card can be played. False otherwise
     */
    public boolean canPlay(Card card) {
        boolean greaterValue  = card.getRankNum() >= this.topCard.getRankNum();
        boolean sameSuit = card.getSuitName().equals(this.topCard.getSuitName());
        if (greaterValue || sameSuit){
            return true;
        }
        return false;
    }

    /**
     * replaces top card with non-null, greater than parameter card
     * @param card played card
     */
    public void play(Card card) {
        // card is playable
        if (card != null && canPlay(card)){
            cardsPlayed += 1;
            this.topCard = card;
        } else {
            System.out.println("Illegal move detected!");
        }
    }

    public int getNumCards() {
        return cardsPlayed;
    }

    public Card getTopCard() {
        return this.topCard;
    }
}
