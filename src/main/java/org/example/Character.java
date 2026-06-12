package org.example;

/**
 * Abstract base class for all characters in the game.
 * Encapsulates health management and forces subclasses to implement action().
 */
public abstract class Character {

    private final String name;
    private final String typeName;
    private final Weapon weapon;
    private final int hpMax;
    private int hp;
    private boolean alive;

    public Character(int hpMax, Weapon weapon, String typeName, String name) {
        this.hpMax = hpMax;
        this.hp = hpMax;
        this.weapon = weapon;
        this.typeName = typeName;
        this.name = name;
        this.alive = true;
    }

    /** Reduces HP by the given amount; marks the character as dead when HP reaches 0. */
    public void takeDamage(int amount) {
        hp = Math.max(0, hp - amount);
        if (hp == 0) {
            alive = false;
        }
    }

    /** Increases HP by the given amount, capped at max HP. */
    public void restoreHp(int amount) {
        hp = Math.min(hpMax, hp + amount);
    }

    public String getName()     { return name; }
    public String getTypeName() { return typeName; }
    public Weapon getWeapon()   { return weapon; }
    public int getHp()          { return hp; }
    public int getHpMax()       { return hpMax; }
    public boolean isAlive()    { return alive; }

    /** Prints a short description of the character's current state. */
    public abstract void action();

    @Override
    public String toString() {
        String status = alive ? String.format("HP: %3d / %3d", hp, hpMax) : "DEFEATED";
        return String.format("%-14s [%-8s]  %s", name, typeName, status);
    }
}
