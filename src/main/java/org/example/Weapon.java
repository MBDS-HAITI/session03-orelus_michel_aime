package org.example;

import java.util.Random;

/**
 * Represents a weapon carried by a character.
 * Damage is randomised within ±15% of the base power each roll.
 */
public class Weapon {

    private final String nameWeapon;
    private final int basicEnergyWeapon;
    private static final Random RNG = new Random();

    public Weapon(String nameWeapon, int basicEnergyWeapon) {
        this.nameWeapon = nameWeapon;
        this.basicEnergyWeapon = basicEnergyWeapon;
    }

    /** Returns a randomised damage value within ±15% of base power. */
    public int rollDamage() {
        double variance = 0.85 + RNG.nextDouble() * 0.30; // [0.85, 1.15]
        return Math.max(1, (int) Math.round(basicEnergyWeapon * variance));
    }

    public String getNameWeapon()      { return nameWeapon; }
    public int getBasicEnergyWeapon()  { return basicEnergyWeapon; }
}
