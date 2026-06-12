package org.example; // Déclare que cette classe appartient au package "org.example"

import java.util.ArrayList; // Importe ArrayList : liste dynamique (taille variable)
import java.util.List;      // Importe l'interface List (type générique de liste)

/**
 * Représente un joueur et son équipe de trois personnages.
 * Gère l'ajout de personnages, la vérification de défaite, et l'affichage de l'équipe.
 */
public class Player {

    private final String name;                   // Nom du joueur (ex: "Alice") — ne change jamais
    private final List<Character> team = new ArrayList<>(); // Liste des 3 personnages de l'équipe
    //                                              ↑ ArrayList permet d'ajouter des éléments dynamiquement

    /**
     * Constructeur : crée un joueur avec son nom.
     * L'équipe commence vide — les personnages sont ajoutés via addCharacter().
     *
     * @param name  Nom du joueur
     */
    public Player(String name) {
        this.name = name; // Mémorise le nom du joueur
    }

    /**
     * Ajoute un personnage à l'équipe du joueur.
     * Appelé 3 fois pendant la phase de configuration.
     *
     * @param character  Le personnage à ajouter
     */
    public void addCharacter(Character character) {
        team.add(character); // Ajoute le personnage à la fin de la liste
    }

    /**
     * Vérifie si le joueur a perdu la partie.
     * Le joueur est vaincu quand TOUS ses personnages sont morts.
     *
     * stream() = parcourt la liste comme un pipeline
     * noneMatch() = retourne true si AUCUN élément ne satisfait la condition
     * Character::isAlive = référence à la méthode isAlive() de Character
     *
     * @return true si tous les personnages sont morts, false sinon
     */
    public boolean isDefeated() {
        return team.stream().noneMatch(Character::isAlive);
        // Équivalent à : aucun personnage n'est vivant → joueur vaincu
    }

    /**
     * Retourne uniquement les personnages encore vivants.
     * Utilisé dans Main pour afficher les choix disponibles pendant le combat.
     *
     * filter(Character::isAlive) = garde seulement ceux dont isAlive() retourne true
     * toList() = convertit le résultat en liste
     *
     * @return Liste des personnages vivants
     */
    public List<Character> getAliveCharacters() {
        return team.stream().filter(Character::isAlive).toList();
    }

    /**
     * Affiche le statut de chaque personnage de l'équipe (vivant ou mort).
     * Chaque ligne utilise le toString() de Character.
     */
    public void printTeamStatus() {
        for (Character c : team) {        // Parcourt tous les personnages (vivants ET morts)
            System.out.println("  " + c); // "  " + c appelle automatiquement c.toString()
        }
    }

    // --- GETTERS ---

    public List<Character> getTeam() { return team; } // Retourne toute l'équipe (avec les morts)
    public String getName()          { return name; } // Retourne le nom du joueur
}
