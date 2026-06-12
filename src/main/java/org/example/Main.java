package org.example; // Déclare que cette classe appartient au package "org.example"

import java.util.ArrayList; // Liste dynamique pour stocker les noms utilisés
import java.util.List;      // Interface générique de liste
import java.util.Scanner;   // Permet de lire les saisies de l'utilisateur dans le terminal

/**
 * Point d'entrée du jeu Battle Arena.
 *
 * Le jeu se déroule en 3 phases :
 *   1. SETUP   — chaque joueur crée son équipe de 3 personnages
 *   2. COMBAT  — les joueurs s'affrontent tour par tour
 *   3. RESULTAT — affichage du gagnant, du nombre de tours, et du statut final
 */
public class Main {

    // Scanner partagé par toutes les méthodes pour lire les entrées clavier
    // "static final" = une seule instance pour toute la classe, ne change jamais
    private static final Scanner SCANNER = new Scanner(System.in);

    // Liste des noms déjà utilisés (en minuscules) pour garantir l'unicité dans toute la partie
    private static final List<String> usedNames = new ArrayList<>();

    /**
     * Méthode principale — point de départ du programme.
     * Java l'appelle automatiquement au lancement.
     */
    public static void main(String[] args) {
        printBanner("BATTLE ARENA"); // Affiche le titre du jeu

        Player player1 = setupPlayer("Player 1"); // Crée et configure l'équipe du joueur 1
        Player player2 = setupPlayer("Player 2"); // Crée et configure l'équipe du joueur 2

        System.out.println("\n--- All characters are ready! Let the battle begin! ---\n");

        int turns = runBattle(player1, player2); // Lance le combat, retourne le nombre de tours joués

        printResults(player1, player2, turns); // Affiche les résultats finaux
    }

    // =========================================================================
    // PHASE 1 — SETUP : création des équipes
    // =========================================================================

    /**
     * Demande au joueur son nom, puis lui fait créer 3 personnages.
     *
     * @param label  Étiquette d'affichage ("Player 1" ou "Player 2")
     * @return       L'objet Player avec son équipe complète
     */
    private static Player setupPlayer(String label) {
        System.out.println("=== " + label + " Setup ===");
        System.out.print("Enter your name: ");
        String playerName = SCANNER.nextLine().trim(); // .trim() supprime les espaces en début/fin
        Player player = new Player(playerName);        // Crée le joueur avec le nom saisi

        List<String> usedTypesInTeam = new ArrayList<>(); // Types déjà choisis dans CETTE équipe

        // Boucle pour créer 3 personnages (slot 1, 2, 3)
        for (int slot = 1; slot <= 3; slot++) {
            System.out.println("\n" + playerName + " — create character " + slot + " of 3:");
            Character character = createCharacter(usedTypesInTeam); // Crée un personnage
            player.addCharacter(character);                          // L'ajoute à l'équipe
            usedTypesInTeam.add(character.getTypeName()); // Marque ce type comme utilisé dans l'équipe
        }
        return player; // Retourne le joueur avec ses 3 personnages
    }

    /**
     * Crée un personnage : demande le type puis le nom.
     *
     * @param usedTypesInTeam  Types déjà pris dans l'équipe (pour éviter les doublons)
     * @return                 Le personnage créé
     */
    private static Character createCharacter(List<String> usedTypesInTeam) {
        String type = chooseType(usedTypesInTeam); // Étape 1 : choisir le type
        String name = chooseName();                // Étape 2 : choisir le nom
        return buildCharacter(type, name);         // Étape 3 : instancier le bon objet
    }

    /**
     * Affiche les types disponibles (ceux non encore choisis dans l'équipe)
     * et retourne le type choisi par le joueur.
     *
     * @param usedTypes  Types déjà utilisés dans cette équipe
     * @return           Le type choisi (ex: "Warrior")
     */
    private static String chooseType(List<String> usedTypes) {
        // Liste de tous les types, puis on retire ceux déjà pris dans l'équipe
        List<String> available = new ArrayList<>(List.of("Warrior", "Magus", "Colossus", "Dwarf"));
        available.removeAll(usedTypes); // Supprime les types déjà utilisés

        System.out.println("Available types:");
        for (int i = 0; i < available.size(); i++) {
            // Affiche chaque option numérotée (1, 2, 3...)
            System.out.printf("  %d) %-10s%n", i + 1, available.get(i));
        }

        // Boucle infinie jusqu'à ce que le joueur entre un choix valide
        while (true) {
            System.out.print("Choose a type [1-" + available.size() + "]: ");
            String input = SCANNER.nextLine().trim(); // Lit la saisie
            try {
                int choice = Integer.parseInt(input); // Convertit le texte en nombre entier
                if (choice >= 1 && choice <= available.size()) { // Vérifie que le choix est dans la plage
                    return available.get(choice - 1); // Retourne le type choisi (-1 car les indices commencent à 0)
                }
            } catch (NumberFormatException ignored) {
                // Si le joueur tape du texte au lieu d'un nombre, Integer.parseInt lance une exception
                // On l'ignore et on réaffiche le prompt
            }
            System.out.println("  Invalid choice, try again.");
        }
    }

    /**
     * Demande un nom au joueur et vérifie :
     * - qu'il n'est pas vide
     * - qu'il n'a pas déjà été utilisé dans toute la partie
     *
     * @return  Le nom valide saisi par le joueur
     */
    private static String chooseName() {
        while (true) { // Boucle jusqu'à obtenir un nom valide
            System.out.print("Enter a unique name: ");
            String name = SCANNER.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("  Name cannot be empty.");
            } else if (usedNames.contains(name.toLowerCase())) {
                // On compare en minuscules pour que "Thor" et "thor" soient considérés identiques
                System.out.println("  That name is already taken. Choose another.");
            } else {
                usedNames.add(name.toLowerCase()); // Enregistre le nom pour les vérifications futures
                return name;                        // Retourne le nom original (avec la casse d'origine)
            }
        }
    }

    /**
     * Instancie le bon objet selon le type choisi.
     * Exemple : type="Warrior" → retourne un new Warrior(name)
     *
     * switch expression (Java 14+) : plus concis que if/else if/else
     *
     * @param type  Le type du personnage ("Warrior", "Magus", etc.)
     * @param name  Le nom du personnage
     * @return      L'objet Character correspondant
     */
    private static Character buildCharacter(String type, String name) {
        return switch (type) {
            case "Warrior"  -> new Warrior(name);   // Crée un Warrior
            case "Magus"    -> new Magus(name);     // Crée un Magus
            case "Colossus" -> new Colossus(name);  // Crée un Colossus
            case "Dwarf"    -> new Dwarf(name);     // Crée un Dwarf
            default         -> throw new IllegalArgumentException("Unknown type: " + type); // Ne devrait jamais arriver
        };
    }

    // =========================================================================
    // PHASE 2 — COMBAT : boucle de jeu tour par tour
    // =========================================================================

    /**
     * Gère la boucle principale du combat.
     * Les joueurs jouent en alternance jusqu'à ce qu'une équipe soit éliminée.
     *
     * @param player1  Premier joueur
     * @param player2  Deuxième joueur
     * @return         Nombre total de tours joués
     */
    private static int runBattle(Player player1, Player player2) {
        int turns = 0;              // Compteur de tours
        Player current  = player1; // Le joueur qui joue en ce moment
        Player opponent = player2; // L'adversaire du joueur actuel

        // Continue tant qu'aucune équipe n'est entièrement éliminée
        while (!player1.isDefeated() && !player2.isDefeated()) {
            turns++; // Incrémente le compteur de tours
            printBanner("TURN " + turns);      // Affiche l'en-tête du tour
            printBothTeams(player1, player2);  // Affiche l'état actuel des deux équipes

            System.out.println("\n--- " + current.getName() + "'s turn ---");
            playTurn(current, opponent); // Le joueur actuel joue son tour

            // Échange les rôles : le joueur actuel devient l'adversaire et vice-versa
            Player tmp = current;
            current    = opponent;
            opponent   = tmp;
        }
        return turns; // Retourne le nombre total de tours pour l'affichage final
    }

    /**
     * Gère un tour complet pour le joueur actif :
     * 1. Choisit un personnage vivant
     * 2. Choisit une action (attaque ou soin)
     * 3. Choisit une cible et exécute l'action
     *
     * @param active    Le joueur dont c'est le tour
     * @param opponent  L'équipe adverse
     */
    private static void playTurn(Player active, Player opponent) {
        Character actor = chooseCharacter(active); // Sélectionne un personnage vivant de l'équipe active
        String action   = chooseAction(actor);      // Détermine et choisit l'action disponible

        // Exécute l'action choisie
        switch (action) {
            case "attack" -> performAttack(actor, opponent); // Attaque un ennemi
            case "heal"   -> performHeal(actor, active);     // Soigne un allié
        }
    }

    /**
     * Affiche la liste des personnages vivants du joueur et lui demande d'en choisir un.
     *
     * @param player  Le joueur qui doit choisir
     * @return        Le personnage sélectionné
     */
    private static Character chooseCharacter(Player player) {
        List<Character> alive = player.getAliveCharacters(); // Récupère uniquement les vivants
        System.out.println("Choose your fighter:");
        for (int i = 0; i < alive.size(); i++) {
            System.out.printf("  %d) %s%n", i + 1, alive.get(i)); // Affiche chaque personnage vivant
        }
        // readInt(1, alive.size()) lit un entier entre 1 et le nombre de personnages vivants
        // -1 pour convertir le choix (1,2,3) en indice de liste (0,1,2)
        return alive.get(readInt(1, alive.size()) - 1);
    }

    /**
     * Détermine quelles actions sont disponibles pour le personnage acteur,
     * puis retourne l'action choisie.
     *
     * - Si le personnage implémente seulement Attacker → attaque automatique
     * - Si le personnage implémente Attacker ET Healer → le joueur choisit
     *
     * "instanceof" vérifie si un objet implémente une interface donnée.
     * Exemple : un Warrior instanceof Attacker → true
     *           un Warrior instanceof Healer  → false
     *
     * @param actor  Le personnage qui va agir
     * @return       "attack" ou "heal"
     */
    private static String chooseAction(Character actor) {
        boolean canAttack = actor instanceof Attacker; // true si le personnage peut attaquer
        boolean canHeal   = actor instanceof Healer;   // true si le personnage peut soigner

        if (canAttack && canHeal) {
            // Le joueur choisit entre attaque et soin
            System.out.println("Choose an action:");
            System.out.println("  1) Attack");
            System.out.println("  2) Heal an ally");
            return readInt(1, 2) == 1 ? "attack" : "heal"; // Opérateur ternaire : si 1 → "attack", sinon "heal"
        }
        // Une seule option disponible : pas besoin de demander
        return canAttack ? "attack" : "heal";
    }

    /**
     * Demande au joueur de choisir un ennemi, puis exécute l'attaque.
     * Affiche les dégâts infligés et signale si l'ennemi est tué.
     *
     * @param attacker    Le personnage qui attaque
     * @param enemyTeam   L'équipe adverse (fournit la liste des cibles)
     */
    private static void performAttack(Character attacker, Player enemyTeam) {
        List<Character> targets = enemyTeam.getAliveCharacters(); // Seuls les ennemis vivants sont ciblables
        System.out.println("Choose a target to attack:");
        for (int i = 0; i < targets.size(); i++) {
            System.out.printf("  %d) %s%n", i + 1, targets.get(i)); // Affiche chaque cible possible
        }
        Character target = targets.get(readInt(1, targets.size()) - 1); // Le joueur choisit sa cible

        // Cast : on "caste" actor en Attacker pour appeler ObjetAttack()
        // C'est sûr car on a vérifié actor instanceof Attacker dans chooseAction()
        int damage = ((Attacker) attacker).ObjetAttack(target);

        // Affiche le résultat de l'attaque
        System.out.printf("%n  %s hits %s with %s — %d damage!%n",
                attacker.getName(), target.getName(),
                attacker.getWeapon().getNameWeapon(), damage);

        if (!target.isAlive()) {
            // Si la cible n'a plus de HP après l'attaque, elle est morte
            System.out.println("  " + target.getName() + " has been defeated!");
        }
    }

    /**
     * Demande au joueur de choisir un allié à soigner, puis exécute le soin.
     * Affiche le nombre de HP restaurés.
     *
     * @param healer     Le personnage qui soigne
     * @param allyTeam   L'équipe alliée (fournit la liste des cibles)
     */
    private static void performHeal(Character healer, Player allyTeam) {
        List<Character> targets = allyTeam.getAliveCharacters(); // On ne peut soigner que des vivants
        System.out.println("Choose an ally to heal:");
        for (int i = 0; i < targets.size(); i++) {
            System.out.printf("  %d) %s%n", i + 1, targets.get(i));
        }
        Character target = targets.get(readInt(1, targets.size()) - 1); // Le joueur choisit l'allié à soigner

        // Cast : on "caste" healer en Healer pour appeler cure()
        int restored = ((Healer) healer).cure(target);

        System.out.printf("%n  %s heals %s for %d HP!%n",
                healer.getName(), target.getName(), restored);
    }

    // =========================================================================
    // PHASE 3 — RÉSULTATS : affichage de fin de partie
    // =========================================================================

    /**
     * Affiche les résultats finaux après la fin du combat :
     * - Le joueur gagnant
     * - Le nombre de tours joués
     * - Le statut de chaque personnage (nom, type, HP ou DEFEATED)
     *
     * @param player1  Premier joueur
     * @param player2  Deuxième joueur
     * @param turns    Nombre total de tours joués
     */
    private static void printResults(Player player1, Player player2, int turns) {
        printBanner("BATTLE OVER");

        // Le gagnant est celui dont l'équipe n'est PAS vaincue
        Player winner = player1.isDefeated() ? player2 : player1;
        System.out.println("  Winner      : " + winner.getName());
        System.out.println("  Total turns : " + turns);

        System.out.println("\n--- Final character status ---");
        System.out.println(player1.getName() + "'s team:");
        player1.printTeamStatus(); // Affiche tous les personnages du joueur 1 (vivants et morts)
        System.out.println(player2.getName() + "'s team:");
        player2.printTeamStatus(); // Affiche tous les personnages du joueur 2
    }

    // =========================================================================
    // MÉTHODES UTILITAIRES
    // =========================================================================

    /**
     * Affiche l'état des deux équipes côte à côte.
     * Appelée au début de chaque tour.
     */
    private static void printBothTeams(Player p1, Player p2) {
        System.out.println(p1.getName() + "'s team:");
        p1.printTeamStatus();
        System.out.println(p2.getName() + "'s team:");
        p2.printTeamStatus();
    }

    /**
     * Affiche une bannière encadrée avec un titre.
     * Exemple :
     *   ========================================
     *     TURN 3
     *   ========================================
     *
     * @param title  Le texte à afficher dans la bannière
     */
    private static void printBanner(String title) {
        System.out.println("\n========================================");
        System.out.println("  " + title);
        System.out.println("========================================");
    }

    /**
     * Lit un entier compris entre min et max depuis le clavier.
     * Redemande tant que la saisie est invalide (texte, hors plage, etc.).
     *
     * @param min  Valeur minimale acceptée
     * @param max  Valeur maximale acceptée
     * @return     L'entier valide saisi par l'utilisateur
     */
    private static int readInt(int min, int max) {
        while (true) { // Boucle infinie jusqu'à une saisie valide
            System.out.print("  > ");
            String input = SCANNER.nextLine().trim(); // Lit la ligne saisie
            try {
                int value = Integer.parseInt(input); // Tente de convertir en entier
                if (value >= min && value <= max) {  // Vérifie que la valeur est dans la plage autorisée
                    return value;                    // Saisie valide : retourne la valeur
                }
            } catch (NumberFormatException ignored) {
                // Saisie non numérique : on ignore l'erreur et on reboucle
            }
            System.out.println("  Please enter a number between " + min + " and " + max + ".");
        }
    }
}
