package org.example;

public class Colossus extends Character implements Attacker,Healer {

    private String typeName;
    private String personName;
    private int hpCol;
    private boolean isAlive;
    private Weapon weapon;

    public Colossus(String typeName,String personName,int hp,Weapon weapon,Boolean alive) {
        super(typeName,hp, weapon);
        this.personName = personName;
        this.typeName = typeName;
        this.hpCol = hp;
        this.isAlive = alive;
    }
    @Override
    public void action() {
        System.out.println("Colossus action");
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getHpCol() {
        return hpCol;
    }

    public void setHpCol(int hpCol) {
        this.hpCol = hpCol;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
