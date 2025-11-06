package org.example;

public class Warrior extends Character implements Attacker {
    private static long  round;
    private String name;
    private Weapon weapon;
    private int hpWar;
    public Warrior(int hpMax, Weapon weapon, String typeName, String name) {
        super(hpMax, weapon, typeName, name);
    }

    @Override
    public void action() {
        System.out.println("Warrior action");
    }
}
