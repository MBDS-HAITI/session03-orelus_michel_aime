package org.example;

public class Magus extends Character implements Healer{
    private String typeName;
    private String personName;
    private int hpMag;
    private boolean isAlive;
    private Weapon weapon;

    public Magus(String typeName,String personName,int hp, Weapon weapon,Boolean alive) {
        super(typeName,hp, weapon);
        this.typeName = typeName;
        this.personName = personName;
        this.hpMag = hp;
        this.isAlive = alive;
    }

    @Override
    public void action() {
        System.out.println("Magus action");
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

    public int getHpMag() {
        return hpMag;
    }

    public void setHpMag(int hpMag) {
        this.hpMag = hpMag;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
