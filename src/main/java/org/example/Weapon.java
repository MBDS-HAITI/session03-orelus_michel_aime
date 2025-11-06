package org.example;

import java.util.Random;

public class Weapon {
    private final String name;
    private final String startPower;
    private static final  Random COL = new Random();


    public Weapon(String name, String startPower) {
        this.name = name;
        this.startPower = startPower;
    }

    public String getName() {
        return name;
    }
    public String getStartPower() {
        return startPower;
    }
}
