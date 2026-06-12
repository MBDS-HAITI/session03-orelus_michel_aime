package org.example; // Déclare que cette classe appartient au package "org.example"

/**
 * Dwarf — Guerrier en verre : très peu de HP, mais l'attaque la plus puissante du jeu.
 * Stratégie : tuer vite avant de mourir.
 *
 * Héritage  : Dwarf "est un" Character.
 * Interface : Dwarf implémente uniquement Attacker (pas de soins).
 *
 * Stats : 70 HP | Hache de Guerre (puissance 40) | Pas de soins
 */
public class Dwarf extends Character implements Attacker {
    //       ↑ hérite de Character  ↑ peut attaquer uniquement

    /**
     * Constructeur simplifié : on passe uniquement le nom.
     * Les stats sont fixes pour tous les Dwarfs.
     *
     * @param name  Nom unique choisi par le joueur
     */
    public Dwarf(String name) {
        super(70, new Weapon("Battle Axe", 40), "Dwarf", name);
        //   ↑ HP max  ↑ arme créée ici                ↑ nom du joueur
    }

    /**
     * Implémentation de action() héritée de Character (obligatoire).
     * Affiche un message de présentation du Dwarf.
     */
    @Override
    public void action() {
        System.out.println(getName() + " raises their Battle Axe with fury!");
    }

    /**
     * Implémentation de l'interface Attacker.
     * Le Dwarf frappe très fort avec sa hache de guerre.
     *
     * @param target  Le personnage ennemi ciblé
     * @return        Les dégâts infligés (les plus élevés du jeu)
     */
    @Override
    public int ObjetAttack(Character target) {
        int damage = getWeapon().rollDamage(); // Dégâts aléatoires basés sur la puissance de la hache (40)
        target.takeDamage(damage);             // Applique les dégâts à la cible
        return damage;
    }
}
