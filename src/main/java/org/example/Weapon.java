package org.example; // Déclare que cette classe appartient au package "org.example"

import java.util.Random; // Importe la classe Random pour générer des nombres aléatoires

/**
 * Représente une arme portée par un personnage.
 * Chaque arme a un nom et une puissance de base.
 * Les dégâts réels sont aléatoires : ±15% autour de la puissance de base.
 */
public class Weapon {

    private final String nameWeapon;       // Nom de l'arme (ex: "Sword", "Battle Axe")
    private final int basicEnergyWeapon;   // Puissance de base de l'arme (ex: 25)

    // Instance unique de Random partagée par toutes les armes (static = appartient à la classe, pas à chaque objet)
    private static final Random RNG = new Random();

    /**
     * Constructeur : crée une arme avec un nom et une puissance de base.
     *
     * @param nameWeapon         Nom de l'arme
     * @param basicEnergyWeapon  Puissance de base (dégâts moyens)
     */
    public Weapon(String nameWeapon, int basicEnergyWeapon) {
        this.nameWeapon        = nameWeapon;       // Mémorise le nom de l'arme
        this.basicEnergyWeapon = basicEnergyWeapon; // Mémorise la puissance de base
    }

    /**
     * Calcule et retourne des dégâts aléatoires pour cette arme.
     *
     * Formule : puissance de base × un coefficient aléatoire entre 0.85 et 1.15
     * Exemples pour une épée de puissance 25 :
     *   - minimum : 25 × 0.85 = ~21 dégâts
     *   - maximum : 25 × 1.15 = ~29 dégâts
     *
     * @return Les dégâts calculés (toujours au moins 1)
     */
    public int rollDamage() {
        // RNG.nextDouble() retourne un nombre entre 0.0 et 1.0
        // On le multiplie par 0.30 pour obtenir [0.0, 0.30], puis on ajoute 0.85 → [0.85, 1.15]
        double variance = 0.85 + RNG.nextDouble() * 0.30;

        // On multiplie la puissance par le coefficient, on arrondit, et on garantit un minimum de 1
        return Math.max(1, (int) Math.round(basicEnergyWeapon * variance));
    }

    // --- GETTERS ---

    public String getNameWeapon()     { return nameWeapon; }       // Retourne le nom de l'arme
    public int getBasicEnergyWeapon() { return basicEnergyWeapon; } // Retourne la puissance de base
}
