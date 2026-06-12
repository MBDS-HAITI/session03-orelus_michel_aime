package org.example;

/**
 * Towering tank: very high HP, medium attack, can also heal allies.
 * Implements both Attacker and Healer interfaces.
 */
public class Colossus extends Character implements Attacker, Healer {

    private static final int HEAL_POWER = 25;

    public Colossus(String name) {
        super(180, new Weapon("Hammer", 20), "Colossus", name);
    }

    @Override
    public void action() {
        System.out.println(getName() + " stands firm like a fortress.");
    }

    @Override
    public int ObjetAttack(Character target) {
        int damage = getWeapon().rollDamage();
        target.takeDamage(damage);
        return damage;
    }

    @Override
    public int cure(Character ally) {
        ally.restoreHp(HEAL_POWER);
        return HEAL_POWER;
    }
}
