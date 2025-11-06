package org.example;

public class Magus extends Character implements Healer{

    public Magus(int hpMax, Weapon weapon, String typeName, String name) {
        super(hpMax, weapon, typeName, name);
    }
    @Override
    public void action() {
        System.out.println("Magus action");
    }
}
