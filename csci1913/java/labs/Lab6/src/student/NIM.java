/*
 * CSCI 1913
 * Lab 06
 * Author: Riley Motylinski
 * */

public class NIM {

    /**
     * create a game state array
     * @param size -- the number of rows
     * @param stickMax -- the largest value
     * @return an array representing a token array. The array in the first position will be one, each following will be
     *     one larger up to the max.
     */
    public static int[] createGameState(int size, int stickMax) {
        int[] gameState = new int[size];

        for (int i = 0; i < gameState.length; i++) {
            // if we have not reached max number yet
            if (i < stickMax) {
                gameState[i] = i + 1;
            } else {
                // max number
                gameState[i] = stickMax;
            }
        }
        return gameState;
    }

    /**
     * This provided function operators similarly to the python isDigit method. You give it a string and it will tell
     * you if the string contains only digits. Give it a read -- the actual design isn't hard, basically a linear search.
     * @param str any string
     * @return true if all letters in the string are digits.
     */
    private static boolean isDigit(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a given move (as represented by two input strings) is valid. This should check if the inputs are numbers
     * if those numbers are in the valid range.
     * @param gameState an array representing the number of tokens in each row.
     * @param row a string representing which row the user wants to take from. 1-indexed.
     * @param takes a string representing how many tokens the user wants to take.
     * @return true if and only if the move would be valid
     */
    public static boolean isValidMove(int[] gameState, String row, String takes) {
        // checking if args are numbers
        if (!isDigit(row) || !isDigit(takes)){
            return false;
        }

        // subtract to get 0-indexing
        // can safely parse as numbers (see above if statement)
        int rowInt = Integer.parseInt(row);
        int takesInt = Integer.parseInt(takes);

        // valid row \in [1,gameState.length)
        if (rowInt < 1 || rowInt > gameState.length){
            return false;
        }
        // takes \in [1,3] and takes < gameState[pos]
        if (takesInt < 1 || takesInt > 3 || takesInt > gameState[rowInt - 1]){
            return false;
        }

        return true;
    }

    /**
     * User System.out.println to represent a token grid to the program user.
     * @param gameState an array representing the number of tokens in each row.
     */
    public static void drawGameState(int[] gameState) {
        // print top
        System.out.println("====================");
        for (int i = 0; i < gameState.length; i++){
            // print row number
            System.out.print((i + 1) + " ");
            for (int j = 0; j < gameState[i];j++){
                // print sticks
                System.out.print("#");
            }
            System.out.println();
        }
        // print bottom of board
        System.out.println("====================");
    }


    /**
     * Create an updated version of the game state. You can assume the row and takes are valid for the gameState array provided.
     * @param gameState an array representing the number of tokens in each row.
     * @param row the row the user wants to take from (0-indexed)
     * @param takes the number of tokens the user wants to take
     * @return a new array representing the state number of tokens in each row after the given numbers were removed.
     */
    public static int[] update(int[] gameState, int row, int takes) {
        // not updating in place
        int[] newGameState = gameState.clone();
        // change gamestate at row
        newGameState[row] -= takes;
        return newGameState;
    }

    /**
     *
     * @param gameState an array representing the number of tokens in each row.
     * @return true if and only if every element of gameState is false.
     */
    public static boolean isOver(int[] gameState) {
        for (int n : gameState){
            // checks if there are any non-zeros left in the array
            // average case _should_ be faster because it will be more
            // common for a game to not be over than to be over
            if (n != 0) {
                return false;
            }
        }

        return true;
    }
}
