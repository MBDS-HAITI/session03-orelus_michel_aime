package org.example;

public class Magus extends Character implements Healer{
    private String personName;
    private int hpMag;
    private boolean isAlive;


    public Magus(String typeName,Weapon weapon,String personName,int hpMag,Boolean alive) {
        super(typeName,weapon);
        this.personName = personName;
        this.hpMag = hpMag;
        this.isAlive = alive;
    }

    @Override
    public void action() {
        System.out.println("Magus action");
    }

    @Override
    public void addHP() {

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
