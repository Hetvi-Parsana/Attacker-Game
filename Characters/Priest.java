package Characters;
/*
CSCI-1110  Juliano Franz
ID: B00877530
Assignment - 03
 */
import Attacks.DamageSpell;
import Attacks.HealingSpell;
import Attacks.MeleeAttack;
import Attacks.Resurrection;

import java.awt.*;

public class Priest extends Caster {

    /**
     * The constructor with following parameter
     * This will arrange the data and initialize the values as per the condition
     * @param name the name of the attack received
     * @param intellect the intellect of the character
     * @param maxHP the maxHP of character
     * @param position the position of the character
     * @param maxMana the maxMana of character
     */
    public Priest(String name, int intellect, int maxHP, Point position, int maxMana) {
        super(name, intellect, maxHP, position, maxMana);
        attackList.add(new MeleeAttack(0, "Wand", 3, 3));
        attackList.add(new DamageSpell(10, "Smite", 10, 7));
        attackList.add(new HealingSpell(20, "Flash Heal", 15, 15));
        attackList.add(new Resurrection());
    }
}