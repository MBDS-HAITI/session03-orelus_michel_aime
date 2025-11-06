package org.example;

public class Colossus extends Character implements Attacker,Healer {
    public Colossus(int hpMax, Weapon weapon, String typeName, String name) {
        super(hpMax, weapon, typeName, name);
    }
    @Override
    public void action() {
        System.out.println("Colossus action");
    }
}
