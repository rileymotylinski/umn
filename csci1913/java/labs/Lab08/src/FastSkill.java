/*
Author: Riley Motylinski
Class: CSCI 1913
 */

public class FastSkill extends Skill{
    /**
     * @param name name of the skill
     * @param strength damage for the skill
     * @param usageLimit how many times the skill can be used
     */
    public FastSkill(String name, int strength, int usageLimit){
        super(name,strength,usageLimit);
    }

    /**
     * damages foe, subtracts speed stat from acting monsters nextTurnTime to essentially
     * make the skill move instantly
     * @param me acting monster
     * @param foe monster being attacked
     */
    public void applyChanges(CodeMonster me, CodeMonster foe){
        foe.adjustHealth(-1*this.getStrength());
        me.setNextTurnTime(me.getNextTurnTime() - me.getSpeedScore());
    };
}
