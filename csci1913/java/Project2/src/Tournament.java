public class Tournament {
    public static void main (String[] args){
        AI[] opponents = {new AI(), new BiggestCardAI(), new SmallestCardAI()};
        // simulating a matchup between every possible combination in this list (including against themselves)
        for (int i = 0; i < opponents.length; i++) {
            for (int j = 0; j < opponents.length; j++) {
                AI ai1 = opponents[i];
                AI ai2 = opponents[j];

                UnoWarMatch match = new UnoWarMatch(ai1, ai2);
                match.playGame();
            }
        }
    }
}
