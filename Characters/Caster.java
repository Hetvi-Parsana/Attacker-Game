package Characters;
/*
CSCI-1110  Juliano Franz
ID: B00877530
Assignment - 03
 */

import Attacks.Attack;
import Attacks.DamageSpell;
import Attacks.HealingSpell;

import java.awt.*;

public abstract class Caster extends RPGCharacter{

    private int maxMana;
    private int currentMana;

    /**
     * The constructor with following parameter
     * This will arrange the data and initialize the values as per the condition
     * @param name the name of the attack received
     * @param intellect the intellect of the character
     * @param maxHP the maxHP of character
     * @param position the position of the character
     * @param maxMana the maxMana of character
     * Strength is initialised to 1
     */
    public Caster(String name, int intellect, int maxHP, Point position, int maxMana) {
        super(name, intellect, 1, maxHP, position);
        this.maxMana = maxMana;
        currentMana = maxMana;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    /**
     * This method will select attack from Arraylist and based on that further damage or heal is done.
     * @param character the character on whom the proceedings are done
     * @param index of the character
     * @return the currentHP of character or the negative integer based on condition
     */
    @Override
    public int attack(RPGCharacter character, int index) {

        // -1 if index not found in the list
        // -2 if the target is not in the given range
        // -3 if Mana is not sufficient
        if(index > attackList.size()) return -1;

        Attack attack = attackList.get(index);

        if(this.getPosition().distance(character.getPosition()) > attack.getRange()) return -2;

        if(currentMana - attack.getCost() <0) return -3;

        if(attack instanceof DamageSpell) {
            attack.interactWithTarget(character, intellect);
            currentMana -= attack.getCost();
            return character.currentHP;
        }

        if(attack instanceof HealingSpell) {
            currentMana -= attack.getCost();
            attack.interactWithTarget(this, intellect);
            return character.currentHP;
        }

        attack.interactWithTarget(character, 0);

        return character.currentHP;
    }

    /**
     *
     * @return the printing statement with addition of Mana beneath Character's representation
     */
    public String toString() {
        return super.toString() + String.format("\n Mana %d/%d", currentMana, maxMana);
    }

}