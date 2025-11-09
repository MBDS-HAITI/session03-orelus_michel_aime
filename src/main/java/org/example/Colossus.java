package org.example;

public class Colossus extends Character implements Attacker,Healer {

    private String personName;
    private int hpCol;
    private boolean isAlive;


    public Colossus(String typeName,Weapon weapon,String personName,int hp,Boolean alive) {
        super(typeName,weapon);
        this.personName = personName;
        this.hpCol = hp;
        this.isAlive = alive;
    }
    @Override
    public void action() {
        System.out.println("Colossus action");
    }

    public void addHP() {
        isAlive = true;
    }

    @Override
    public int removeHP() {
        return 0;
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

}
