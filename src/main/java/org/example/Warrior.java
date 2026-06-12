package org.example; // Déclare que cette classe appartient au package "org.example"

/**
 * Warrior — Combattant équilibré.
 *
 * Héritage : Warrior "est un" Character (il hérite de tous ses attributs et méthodes).
 * Interface : Warrior implémente Attacker, donc il DOIT fournir la méthode ObjetAttack().
 *
 * Stats : 100 HP | Épée (puissance 25)
 * Capacité : Attaque uniquement
 */
public class Warrior extends Character implements Attacker {
    //         ↑ hérite de Character     ↑ s'engage à implémenter ObjetAttack()

    /**
     * Constructeur simplifié : on passe uniquement le nom.
     * Les stats (HP, arme, type) sont fixes pour tous les Warriors.
     *
     * super(...) appelle le constructeur de la classe parente (Character).
     *
     * @param name  Nom unique choisi par le joueur
     */
    public Warrior(String name) {
        super(100, new Weapon("Sword", 25), "Warrior", name);
        //    ↑ HP max  ↑ arme créée ici            ↑ nom du joueur
    }

    /**
     * Implémentation obligatoire de la méthode abstraite action() de Character.
     * Affiche un message de présentation du Warrior.
     */
    @Override
    public void action() {
        // getName() est hérité de Character — retourne le nom du personnage
        // getWeapon().getNameWeapon() retourne le nom de l'arme (ex: "Sword")
        System.out.println(getName() + " stands ready with their " + getWeapon().getNameWeapon() + ".");
    }

    /**
     * Implémentation obligatoire de l'interface Attacker.
     * Calcule les dégâts via l'arme, les applique à la cible, et retourne la valeur.
     *
     * @param target  Le personnage ennemi qui reçoit l'attaque
     * @return        Les dégâts infligés
     */
    @Override
    public int ObjetAttack(Character target) {
        int damage = getWeapon().rollDamage(); // Tire un nombre de dégâts aléatoires avec l'arme
        target.takeDamage(damage);             // Applique les dégâts à la cible (méthode de Character)
        return damage;                         // Retourne la valeur pour l'afficher dans Main
    }
}
