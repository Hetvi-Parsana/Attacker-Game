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

public abstract class Melee extends RPGCharacter{

    private int maxEnergy;
    private int currentEnergy;

    /**
     * The constructor with following parameter
     * This will arrange the data and initialize the values as per the condition
     * @param name the name of the attack received
     * @param strength the strength of the character
     * @param maxHP the maxHP of character
     * @param position the position of the character
     * @param maxEnergy the maxEnergy of character
     */
    public Melee(String name, int strength, int maxHP, Point position, int maxEnergy) {
        super(name, 1, strength, maxHP, position);
        this.maxEnergy = maxEnergy;
        currentEnergy = maxEnergy;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    /**
     * This method deals with Melee character and most attacks are physical consuming more energy
     * @param character the character on whom the proceedings are done
     * @param index of the character
     * @return  the currentHP of character or the negative integer based on condition
     */
    @Override
    public int attack(RPGCharacter character, int index) {

        // -1 if index not found in the list
        // -2 if the target is not in the given range
        // -3 if Mana is not sufficient

        if(index > attackList.size()) return -1;

        Attack attack = attackList.get(index);

        if(this.getPosition().distance(character.getPosition()) > attack.getRange()) return -2;

        if(currentEnergy - attack.getCost() < 0) return -3;

        // Reducing the energy cost and calling method from the chosen attack
        currentEnergy -= attack.getCost();
        character.takeDamage(attack.getDamage() + strength);

        return character.currentHP;
    }

    /**
     *
     * @return the print statement with addition of Energy representation.
     */
    @Override
    public String toString() {
        return super.toString() + String.format("\n Energy %d/%d", currentEnergy, maxEnergy);
    }
}