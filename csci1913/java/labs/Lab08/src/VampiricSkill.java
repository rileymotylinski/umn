/*
Author: Riley Motylinski
Class: CSCI 1913
 */

public class VampiricSkill extends Skill {
    /**
     * @param name of the skill
     * @param strength how much damage the skill does
     * @param usageLimit how many times the skill can be used
     */
    public VampiricSkill(String name, int strength, int usageLimit){
        super(name,strength,usageLimit);
    };

    /**
     * adjusts me to increase health and decreases foe's health by equal amount
     * @param me acting monster
     * @param foe monster being attacked
     */
    @Override
    public void applyChanges(CodeMonster me, CodeMonster foe){
        me.adjustHealth(this.getStrength());
        foe.adjustHealth(-1*this.getStrength());
    };
}
