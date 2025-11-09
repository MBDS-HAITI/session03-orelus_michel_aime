package org.example;
import org.example.Weapon;

public class Warrior extends Character{
    private String typeName;
    private int hpWar;
    private boolean isAlive;
    private Weapon weapon;

    public Warrior(String typeName,int hp,Weapon weapon,Boolean alive) {
        super(typeName,hp, weapon);
    }
    @Override
    public void action() {
        System.out.println("Warrior action");
    }
}
