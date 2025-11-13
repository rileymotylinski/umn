/*
Author: Riley Motylinski
Class: CSCI 1913
 */

public class CodeMonster {
    private String name;
    private int currentHp;
    private int maxHp;
    private Skill[] moves;
    private int moveIndex;
    // smaller speed score -> faster monster (first in line?)
    private double speedScore;
    private double nextTurnTime;

    /**
     *
     * @param maxHp maxHp of the monster
     * @param speedScore nextTurnTime incrememnt amount
     * @param name for the monster
     * @param moves set of skills the monster can preform
     */
    public CodeMonster(int maxHp, double speedScore, String name, Skill[] moves){
        this.maxHp = maxHp;
        this.speedScore = speedScore;
        this.name = name;
        this.moves = moves;
        this.moveIndex = 0;
        this.currentHp = this.maxHp;
        this.nextTurnTime = this.speedScore;
    };

    /**
     * resets monsters object fields to default/refreshed state
     */
    public void prepForBattle(){
        this.currentHp = this.maxHp;
        this.nextTurnTime = this.speedScore;
        this.moveIndex = 0;

        for (int i = 0; i < this.moves.length; i++) {
            moves[i].refresh();
        }
    };

    /**
     * updates nextTurnTime to later time
     * @return next move in moves
     */
    public Skill takeTurn(){
        this.setNextTurnTime(this.nextTurnTime + this.speedScore);

        int currentIndex = this.moveIndex;

        if (this.moveIndex + 1 >= this.moves.length){
            this.moveIndex = 0;
        } else {
            this.moveIndex += 1;
        }

        return moves[currentIndex];

    };
    /**
     * @return whether the current monster is living
     */
    public boolean isAlive(){
        return this.currentHp > 0;
    };

    /**
     * updates the health for the current monster
     * @param amount amount by which to add/remove from a monsters health. Positive is add and vice versa.
     */
    public void adjustHealth(int amount){
        int newHp = this.currentHp + amount;

        if (newHp < 0) {
            this.currentHp = 0;
        } else if (newHp > this.maxHp) {
            this.currentHp = maxHp;
        } else {
            this.currentHp = newHp;
        }

    };

    /**
     * updates nextTurnTime
     * @param nextTurnTime new turn time.
     */
    public void setNextTurnTime(double nextTurnTime){
        this.nextTurnTime = nextTurnTime;
    };
    public double getNextTurnTime(){
        return this.nextTurnTime;
    };


    public int getHp(){
        return this.currentHp;
    };


    public int getMaxHp(){
        return this.maxHp;
    };
    public Skill[] getMoves(){
        return this.moves;
    };
    public String getName(){
        return this.name;
    };
    public double getSpeedScore(){
        return this.speedScore;
    };

    /**
     * @return Monster info in the format: Name currentHp/maxHp
     */
    public String toString(){
        return  this.name + " " + this.currentHp + "/" + this.maxHp;
    };
}
