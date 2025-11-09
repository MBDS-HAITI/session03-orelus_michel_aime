package org.example;

public class Dwarf extends Character {

    private String typeName;
    private String personName;
    private int hpDw;
    private boolean isAlive;


    public Dwarf(String typeName,Weapon weapon,String personName,int hpDw,Boolean alive) {
        super(typeName,weapon);
        this.personName = personName;
        this.hpDw = hpDw;
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

    public int getHpDw() {
        return hpDw;
    }

    public void setHpDw(int hpDw) {
        this.hpDw = hpDw;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
