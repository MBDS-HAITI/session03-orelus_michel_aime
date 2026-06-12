package org.example;

/**
 * Arcane caster: high HP, weak attack, but can heal allies.
 * Implements both Attacker and Healer interfaces.
 */
public class Magus extends Character implements Attacker, Healer {

    private static final int HEAL_POWER = 35;

    public Magus(String name) {
        super(130, new Weapon("Staff", 15), "Magus", name);
    }

    @Override
    public void action() {
        System.out.println(getName() + " channels arcane energy.");
    }

    @Override
    public int ObjetAttack(Character target) {
        int damage = getWeapon().rollDamage();
        target.takeDamage(damage);
        return damage;
    }

    /** Restores a fixed amount of HP to the target ally. */
    @Override
    public int cure(Character ally) {
        ally.restoreHp(HEAL_POWER);
        return HEAL_POWER;
    }
}
