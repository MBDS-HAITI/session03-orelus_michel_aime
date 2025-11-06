package org.example;

public class Dwarf extends Character {
    private static long  round;
    private String name;
    private Weapon weapon;
    private static int hpDr;

    public Dwarf(int hpMax, Weapon weapon, String typeName, String name) {
        super(hpMax, weapon, typeName, name);
    }

    @Override
    public void action() {
        System.out.println("Dwarf action");
    }
}
