package Characters;
/*
CSCI-1110  Juliano Franz
ID: B00877530
Assignment - 03
 */
import Attacks.DamageSpell;
import Attacks.MeleeAttack;

import java.awt.*;

public class Mage extends Caster{

    /**
     * The constructor with following parameter
     * This will arrange the data and initialize the values as per the condition
     * @param name the name of the attack received
     * @param intellect the intellect of the character
     * @param maxHP the maxHP of character
     * @param position the position of the character
     * @param maxMana the maxMana of character
     */
    public Mage(String name, int intellect, int maxHP, Point position, int maxMana) {
        super(name, intellect, maxHP, position, maxMana);
        attackList.add(new MeleeAttack(0, "Staff", 3, 3));
        attackList.add(new DamageSpell(20, "Fire Ball", 10, 20));
        attackList.add(new DamageSpell(15, "Frost Ball", 7, 15));
        attackList.add(new DamageSpell(30, "Lightning", 15, 20));
    }

}