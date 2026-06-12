package org.example; // Déclare que cette interface appartient au package "org.example"

/**
 * Interface définissant la capacité de soigner.
 *
 * Une interface est un "contrat" : toute classe qui l'implémente
 * s'engage à fournir la méthode cure().
 *
 * Classes qui implémentent Healer : Magus, Colossus
 */
public interface Healer {

    /**
     * Soigne un personnage allié et retourne la quantité de HP restaurés.
     *
     * @param objective  Le personnage allié qui reçoit les soins
     * @return           Le nombre de HP restaurés
     */
    int cure(Character objective);
}
