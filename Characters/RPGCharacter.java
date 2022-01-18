package Characters;
/*
CSCI-1110  Juliano Franz
ID: B00877530
Assignment - 03
This problem is related to different characters of the class
 */

import Attacks.Attack;

import java.awt.*;
import java.util.ArrayList;

public abstract class RPGCharacter {
    private String name;
    private int maxHP;
    private Point position;

    protected int currentHP;
    protected int intellect;
    protected int strength;
    protected ArrayList<Attack> attackList;

    /**
     * The constructor with following parameter
     * This will arrange the data and initialize the values as per the condition
     * @param name the name of the attack received
     * @param intellect the intellect of the character
     * @param strength the strength of the character
     * @param maxHP the maxHP of character
     * @param position the position of the character
     */
    public RPGCharacter(String name, int intellect, int strength, int maxHP, Point position) {
        this.name = name;
        this.intellect = intellect;
        this.strength = strength;
        this.maxHP = maxHP;
        this.position = position;
        currentHP = maxHP;
        attackList = new ArrayList<>();
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public Point getPosition() {
        return position;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public String getName() {
        return name;
    }

    public void move(int x, int y) {
        position.translate(x, y);
    }

    /**
     * The method that deals with the damage done to the character
     * @param damage the int received as points of damage to be reduced.
     * @return true if the deduction from currentHP was done successfully.
     */
    public boolean takeDamage(int damage) {
        currentHP -= damage;
        if(currentHP <=0 ){
            currentHP = 0;
            return false;
        }
        return true;
    }

    /**
     * The method that deals with the healing done to the character
     * @param heal the int received as points to be added.
     * @return true if the addition to currentHP was done successfully.
     */
    public boolean heal(int heal) {
        currentHP += heal;
        if(currentHP >= maxHP) {
            currentHP = maxHP;
            return true;
        }
        return false;
    }

    public abstract int attack(RPGCharacter character, int index);

    /**
     *
     * @return the printing statement as per the requirements.
     */
    public String getAttacks() {
        String returnVal = "";
        Attack attack;

        for(int i=0; i<attackList.size(); i++) {
            returnVal = returnVal + String.format("%d - %s", i, attackList.get(i));

            if(i != attackList.size() - 1){
                returnVal = returnVal + "\n";
            }
        }

        return returnVal;
    }

    /**
     *
     * @return the printing statement of the Characters as mentioned.
     */
    @Override
    public String toString() {
        return String.format("%s (%s) - %d/%d", name, getClass().getSimpleName(), currentHP, maxHP);
    }

}
