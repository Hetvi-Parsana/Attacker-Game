package Characters;
/*
CSCI-1110  Juliano Franz
ID: B00877530
Assignment - 03
 */
import Attacks.MeleeAttack;

import java.awt.*;

public class Warrior extends Melee {

    /**
     * The constructor with following parameter
     * This will arrange the data and initialize the values as per the condition
     * @param name the name of the attack received
     * @param strength the strength of the character
     * @param maxHP the maxHP of character
     * @param position the position of the character
     * @param maxEnergy the maxEnergy of character
     */
    public Warrior(String name, int strength, int maxHP, Point position, int maxEnergy) {
        super(name, strength, maxHP, position, maxEnergy);
        attackList.add(new MeleeAttack(0, "Punch", 5, 3));
        attackList.add(new MeleeAttack(3, "Slam", 5, 3));
        attackList.add(new MeleeAttack(20, "Charge", 30, 15));
    }

}