package org.example; // Déclare que cette classe appartient au package "org.example"

/**
 * Magus — Lanceur de sorts : HP élevés, attaque faible, mais peut soigner ses alliés.
 *
 * Héritage  : Magus "est un" Character.
 * Interfaces: Magus implémente Attacker ET Healer.
 *             → Il DOIT fournir ObjetAttack() ET cure().
 *
 * Stats : 130 HP | Bâton (puissance 15) | Soins : 35 HP
 */
public class Magus extends Character implements Attacker, Healer {
    //        ↑ hérite de Character  ↑ peut attaquer    ↑ peut soigner

    // Constante : la quantité de HP restaurés à chaque soin (35 HP fixe)
    // "private static final" = valeur constante partagée par tous les Magus, ne change jamais
    private static final int HEAL_POWER = 35;

    /**
     * Constructeur simplifié : on passe uniquement le nom.
     * Les stats sont fixes pour tous les Magus.
     *
     * @param name  Nom unique choisi par le joueur
     */
    public Magus(String name) {
        super(130, new Weapon("Staff", 15), "Magus", name);
        //    ↑ HP max  ↑ arme créée ici           ↑ nom du joueur
    }

    /**
     * Implémentation de action() héritée de Character (obligatoire).
     * Affiche un message de présentation du Magus.
     */
    @Override
    public void action() {
        System.out.println(getName() + " channels arcane energy.");
    }

    /**
     * Implémentation de l'interface Attacker.
     * Le Magus peut attaquer avec son bâton, mais les dégâts sont faibles.
     *
     * @param target  Le personnage ennemi ciblé
     * @return        Les dégâts infligés
     */
    @Override
    public int ObjetAttack(Character target) {
        int damage = getWeapon().rollDamage(); // Dégâts aléatoires basés sur la puissance du bâton (15)
        target.takeDamage(damage);             // Applique les dégâts à la cible
        return damage;
    }

    /**
     * Implémentation de l'interface Healer.
     * Restaure HEAL_POWER (35) HP à un allié.
     *
     * @param ally  Le personnage allié à soigner
     * @return      Le nombre de HP restaurés (toujours 35)
     */
    @Override
    public int cure(Character ally) {
        ally.restoreHp(HEAL_POWER); // Appelle restoreHp() sur l'allié (méthode de Character)
        return HEAL_POWER;          // Retourne 35 pour affichage dans Main
    }
}
