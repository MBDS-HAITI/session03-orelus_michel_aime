package org.example;
import org.example.Weapon;

public class Warrior extends Character{
    private String typeName;
    private String personName;
    private int hpWar;
    private boolean isAlive;
    private Weapon weapon;

    public Warrior(String typeName,String personName,int hp,Weapon weapon,Boolean alive) {
        super(typeName,hp, weapon);
        this.typeName = typeName;
        this.personName = personName;
        this.hpWar = hp;
        this.isAlive = alive;
    }
    @Override
    public void action() {
        System.out.println("Warrior action");
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
