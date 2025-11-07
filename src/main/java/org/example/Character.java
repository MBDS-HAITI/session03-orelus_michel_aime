package org.example;

public class  Character {
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

    public String getName() {
        return name;
    }

    public String getTypeName() {
        return typeName;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getHpMax() {
        return hpMax;
    }

    public int getHp() {
        return hp;
    }

    public boolean isAlive() {
        return alive;
    }

}
