package org.example;

abstract class  Character {
    private final String typeName;
    private final Weapon weapon;
    private final int hpMax;
    private int hp;


    public Character(String typeName,int hp, Weapon weapon) {
        this.typeName = typeName;
        this.hpMax = hp;
        this.weapon = weapon;

    }
    public abstract void action();
}
