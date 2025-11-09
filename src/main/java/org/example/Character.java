package org.example;

abstract class  Character {
    private  String typeName;
    private  Weapon weapon;

    public Character(String typeName,Weapon weapon) {
        this.typeName = typeName;
        this.weapon = weapon;

    }
    public abstract void action();


}
