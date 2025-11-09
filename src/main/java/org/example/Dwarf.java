package org.example;

public class Dwarf extends Character {

    private String typeName;
    private int hpDr;
    private boolean isAlive;
    private Weapon weapon;

    public Dwarf(String typeName,int hp, Weapon weapon,Boolean alive) {
        super(typeName,hp, weapon);
    }

    @Override
    public void action() {
        System.out.println("Dwarf action");
    }
}
