package org.example; // Déclare que cette interface appartient au package "org.example"

/**
 * Interface définissant la capacité d'attaquer.
 *
 * Une interface est un "contrat" : toute classe qui l'implémente
 * s'engage à fournir la méthode ObjetAttack().
 *
 * Classes qui implémentent Attacker : Warrior, Magus, Colossus, Dwarf
 */
public interface Attacker {

    /**
     * Attaque un personnage cible et retourne les dégâts infligés.
     *
     * @param objective  Le personnage qui reçoit l'attaque
     * @return           Le nombre de dégâts infligés
     */
    int ObjetAttack(Character objective);
}
