package org.example;

public class Warrior extends Character implements Attacker {
    private static long  round;
    private String name;
    private Weapon weapon;
    private int hpWar;
    private boolean isAlive;
    public Warrior(int hpWar, Weapon weapon, String typeName, String name) {

        super(hpWar, weapon, typeName, name);
    }

    @Override
    public void action() {
        System.out.println("Warrior action");
    }
}
