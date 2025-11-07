package org.example;

import java.util.Random;

public class Weapon {
    private final String nameWeapon;
    private final int basicEnergyWeapon;
    private static final Random RNG = new Random();

    public Weapon(String nameWeapon, int basicEnergyWeapon) {
        this.nameWeapon = nameWeapon;
        this.basicEnergyWeapon = basicEnergyWeapon;
    }

    public int objective() {
        double variance = 0.85 + RNG.nextDouble() * (1.15 - 0.85);
        return Math.max(0, (int) Math.round(basicEnergyWeapon * variance));
    }

    public String getNameWeapon() {
        return nameWeapon;
    }

    public int getBasicEnergyWeapon() {
        return basicEnergyWeapon;
    }
}
