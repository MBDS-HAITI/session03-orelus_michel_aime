package org.example;

abstract class  Character {
    private final String name;
    private final String typeName;
    private final Weapon weapon;
    private final int hpMax;
    private int hp;
    private boolean alive = true;

    public Character(int hpMax, Weapon weapon, String typeName, String name) {
        this.hpMax = hpMax;
        this.weapon = weapon;
        this.typeName = typeName;
        this.name = name;
    }
    public abstract void action();
}
