import java.lang.Math;

public class UnoWarMatch {
    private AI ai1;
    private AI ai2;

    public UnoWarMatch(AI ai1, AI ai2){
        this.ai1 = ai1;
        this.ai2 = ai2;
    }

    /**
     * plays a single round of a game. A game is 10 rounds.
     * @param first who plays first. 1 for Ai1, 2 for Ai2
     * @param cardPile cardPile to play the round with
     * @param hand1 hand for Ai1
     * @param hand2 hand for Ai2
     * @return 1 for Ai1 win, 2 for Ai2 Win
     */
    public int playRound(int first, CardPile cardPile, Hand hand1, Hand hand2) {
        AI bot1 = this.ai1;
        AI bot2 = this.ai2;
        // if AI2 plays first
        if (first == 2) {
            bot1 = this.ai2;
            bot2 = this.ai1;
        }

        while (true) {
            Card play1 = bot1.getPlay(hand1,cardPile);
            Card play2 = bot2.getPlay(hand2,cardPile);
            // if no play exists for the Ai, then they lose
            if (play1 == null) {
                return 1;
            } else if (play2 == null) {
                return 2;
            }

            // this is fine because we check they both have valid plays before they actually play their card

            // AIi plays first
            cardPile.play(play1);
            hand1.remove(play1);

            // Ai2 plays second
            cardPile.play(play2);
            hand2.remove(play2);

        }

    }

    /**
     * plays game with new deck and new hands
     * @return true if AI1 won, False if AI2 won
     */
    public boolean playGame() {
        // preparing game state
        Deck d = new Deck();
        CardPile cardPile = new CardPile(d.draw());

        Hand hand1 = new Hand(d,5);
        Hand hand2 = new Hand(d,5);
        System.out.println(hand1);
        System.out.println(hand2);
        System.out.println(cardPile.getTopCard());

        int rounds1 = 0;
        int rounds2 = 0;

        int winner = 1;
        // whoever gets to 10 wins first wins the game
        while (rounds1 != 10 && rounds2 != 10) {
            if (playRound(winner, cardPile, hand1, hand2) == 1) {
                rounds1 += 1;
                winner = 1;
            } else {
                rounds2 += 1;
                winner = 2;
            }
        }
        // true of AI1 won 10 rounds
        return rounds1 == 10;
    }

    /**
     * determine the winrate for an ai over n trails
     * @param nTrials number of trials to run.
     * @return win rate of AI1. Assuming only 2 players 1-AI1 win rate will give AI2 win rate
     */
    public double winRate(int nTrials) {
        double AI1Wins = 0;
        for (int i = 0; i < nTrials; i++) {
            if (playGame()) {
                AI1Wins += 1;
            }
        }

        return AI1Wins / nTrials;
    }
}
