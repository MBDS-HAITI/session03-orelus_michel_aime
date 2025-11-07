package org.example;

public class Warrior extends Character {

    public Warrior(int hpMax, Weapon weapon, String typeName, String name) {
        super(hpMax, weapon, typeName, name);
    }

    @Override
    public void action() {
        System.out.println("Warrior action");
    }
}
