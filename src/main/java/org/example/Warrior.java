package org.example;
import org.example.Weapon;

public class Warrior extends Character{
    private String personName;
    private int hpWar;
    private boolean isAlive;


    public Warrior(String typeName,Weapon weapon,String personName,int hpWar,Boolean alive) {
        super(typeName,weapon);
        this.personName = personName;
        this.hpWar = hpWar;
        this.isAlive = alive;
    }

    @Override
    public void action() {
        System.out.println("Warrior action");
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getHpWar() {
        return hpWar;
    }

    public void setHpWar(int hpWar) {
        this.hpWar = hpWar;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
