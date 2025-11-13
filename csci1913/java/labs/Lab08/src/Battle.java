/*
Author: Riley Motylinski
Class: CSCI 1913
 */

public class Battle {

    /**
    @param one - monster one
    @param two - monster two
     */
    public static void doOneTurn(CodeMonster one, CodeMonster two){


        if (one.getNextTurnTime() <= two.getNextTurnTime()){

            Skill move = one.takeTurn();

            move.useSkill(one, two);

            System.out.println(one.toString() + " uses " + move.toString() + " on " + two.toString());

        } else {
            Skill move = two.takeTurn();

            move.useSkill(two, one);

            System.out.println(two.toString() + " uses " + move.toString() + " on " + one.toString());
        }
    };

    /**
     @param one - monster one
     @param two - monster two
     @return winning monster
     */
    public static CodeMonster battle(CodeMonster one, CodeMonster two){
        one.prepForBattle();
        two.prepForBattle();

        System.out.println(one.toString() + " vs. " + two.toString());

        while(one.isAlive() && two.isAlive()){
            doOneTurn(one, two);
        }

        CodeMonster winner = one;

        if(one.isAlive()) {
            System.out.println(one.toString() + " wins!");
        } else {
            System.out.println(two.toString() + " wins!");
            winner = two;
        }

        return winner;
    };
}
