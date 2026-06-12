package org.example; // Déclare que cette classe appartient au package "org.example"

/**
 * Colossus — Tank : très résistant, attaque moyenne, peut aussi soigner ses alliés.
 *
 * Héritage  : Colossus "est un" Character.
 * Interfaces: Colossus implémente Attacker ET Healer.
 *             → Il DOIT fournir ObjetAttack() ET cure().
 *
 * Stats : 180 HP | Marteau (puissance 20) | Soins : 25 HP
 */
public class Colossus extends Character implements Attacker, Healer {
    //          ↑ hérite de Character  ↑ peut attaquer    ↑ peut soigner

    // Constante : la quantité de HP restaurés à chaque soin (25 HP fixe)
    private static final int HEAL_POWER = 25;

    /**
     * Constructeur simplifié : on passe uniquement le nom.
     * Les stats sont fixes pour tous les Colossus.
     *
     * @param name  Nom unique choisi par le joueur
     */
    public Colossus(String name) {
        super(180, new Weapon("Hammer", 20), "Colossus", name);
        //    ↑ HP max  ↑ arme créée ici              ↑ nom du joueur
    }

    /**
     * Implémentation de action() héritée de Character (obligatoire).
     * Affiche un message de présentation du Colossus.
     */
    @Override
    public void action() {
        System.out.println(getName() + " stands firm like a fortress.");
    }

    /**
     * Implémentation de l'interface Attacker.
     * Le Colossus frappe avec son marteau.
     *
     * @param target  Le personnage ennemi ciblé
     * @return        Les dégâts infligés
     */
    @Override
    public int ObjetAttack(Character target) {
        int damage = getWeapon().rollDamage(); // Dégâts aléatoires basés sur la puissance du marteau (20)
        target.takeDamage(damage);             // Applique les dégâts à la cible
        return damage;
    }

    /**
     * Implémentation de l'interface Healer.
     * Restaure HEAL_POWER (25) HP à un allié.
     *
     * @param ally  Le personnage allié à soigner
     * @return      Le nombre de HP restaurés (toujours 25)
     */
    @Override
    public int cure(Character ally) {
        ally.restoreHp(HEAL_POWER); // Appelle restoreHp() sur l'allié (méthode de Character)
        return HEAL_POWER;          // Retourne 25 pour affichage dans Main
    }
}
