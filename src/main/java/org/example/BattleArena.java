package org.example;

import java.util.Scanner;

public class BattleArena {
    private int round;
    private Scanner scanner = new Scanner(System.in);

    public void play() {
        System.out.println("=== Jeu  (Battle Arena OMA) - 2 joueurs ===");
        boolean playAgain;
        do {
            //resetBoard();

            /*
            boolean finished = false;
            while (!finished) {
                printBoard();
                playerMove();
                if (checkWin(currentPlayer)) {
                    printBoard();
                    System.out.println("Le joueur '" + currentPlayer + "' a gagné ! Bravo !");
                    finished = true;
                } else if (isDraw()) {
                    printBoard();
                    System.out.println("Match nul !");
                    finished = true;
                } else {
                    switchPlayer();
                }
            }
            */

            playAgain = askPlayAgain();
        } while (playAgain);
        System.out.println("Merci d'avoir joué — à bientôt !");

    }

    private void resetPlayGround() {
        System.out.println("Resetting playground...");
    }

    private void switchPlayer() {

    }

    private boolean checkIfPlayerWin(char player) {
        return false;
    }


    private boolean askPlayAgain() {
        while (true) {
            System.out.print("Voulez-vous rejouer ? (o/n) : ");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals("o") || answer.equals("oui")) return true;
            if (answer.equals("n") || answer.equals("non")) return false;
            System.out.println("Réponse non comprise — tape 'o' pour oui ou 'n' pour non.");
        }
    }
}
