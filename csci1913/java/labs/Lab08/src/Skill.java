/*
Author: Riley Motylinski
Class: CSCI 1913
 */

public class Skill {
    private String name;
    private int strength;
    private int usageLimit;
    private int usagesLeft;

    /**
     * @param name name for the skill
     * @param strength damage the skill does
     * @param usageLimit how many times the skill can be preformed
     */
    public Skill(String name, int strength, int usageLimit){
        this.name = name;
        this.strength = strength;
        this.usageLimit = usageLimit;
        this.usagesLeft = this.usageLimit;
    };
    public String getName(){
        return this.name;
    };
    public void refresh(){
        this.usagesLeft = this.usageLimit;
    };
    public int getStrength(){
        return this.strength;
    };
    public int getUsageLimit(){
        return this.usageLimit;
    };
    public int getUsageLeft(){
        return this.usagesLeft;
    };

    /**
     * validates the skill can be used, then decrements usagesLeft
     * @param me acting monster
     * @param foe monster being attack
     */
    public void useSkill(CodeMonster me, CodeMonster foe){
        if (this.usagesLeft > 0){
            this.applyChanges(me,foe);
            this.usagesLeft -= 1;

        }
    };

    /**
     * updates foes health to account for damage from Skill
     * @param me acting monster
     * @param foe monster being attacked
     */
    public void applyChanges(CodeMonster me, CodeMonster foe){
        if (foe.getHp() > this.strength){
            foe.adjustHealth(-1*this.strength);
        } else {
            foe.adjustHealth(-1*foe.getHp());
        }

    };

    /**
     * user friendly version of skill
     * @return string version of SkillName usagesLeft/maxUsages
     */
    public String toString(){
        return this.name + " " + this.getUsageLeft() + "/" + this.usageLimit;
    };
}
