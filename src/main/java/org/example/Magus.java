package org.example;

public class Magus extends Character implements Healer{
    private static long  round;

    private String typeName;
    private int hpMag;
    private boolean isAlive;
    private Weapon weapon;

    public Magus(String typeName,int hp, Weapon weapon,Boolean alive) {
        super(typeName,hp, weapon);
    }
    @Override
    public void action() {
        System.out.println("Magus action");
    }
}
