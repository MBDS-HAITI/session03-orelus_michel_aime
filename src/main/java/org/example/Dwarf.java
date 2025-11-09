package org.example;

public class Dwarf extends Character {

    private String typeName;
    private String personName;
    private int hpDr;
    private boolean isAlive;
    private Weapon weapon;

    public Dwarf(String typeName,String personName,int hp, Weapon weapon,Boolean alive) {
        super(typeName,hp, weapon);
        this.typeName = typeName;
        this.personName = personName;
        this.hpDr = hp;
        this.isAlive = alive;
    }

    @Override
    public void action() {
        System.out.println("Dwarf action");
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

    public int getHpDr() {
        return hpDr;
    }

    public void setHpDr(int hpDr) {
        this.hpDr = hpDr;
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
