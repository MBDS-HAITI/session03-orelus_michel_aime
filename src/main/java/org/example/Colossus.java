package org.example;

public class Colossus extends Character implements Attacker,Healer {

    private String typeName;
    private int hpCol;
    private boolean isAlive;
    private Weapon weapon;

    public Colossus(String typeName,int hp,Weapon weapon,Boolean alive) {
        super(typeName,hp, weapon);
    }
    @Override
    public void action() {
        System.out.println("Colossus action");
    }


}
