package org.example;
import java.util.*;
import java.util.Scanner;

public class BattleArena {
    private int round=0;
    private Scanner scanner = new Scanner(System.in);



    public void play() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Jeu  (Battle Arena OMA) - 2 joueurs ===");

        Player player1 = new Player();
        Player player2 = new Player();

        boolean playAgain;
        do {

            // Ask user for 3 strings
            System.out.println("Choose the name of the team 1");
            System.out.print("> ");
            String team_name1 = sc.nextLine();


            System.out.println("Choose 3 players");
            System.out.println("1 Warrior  2 Magus  3 Colossus  4 Dwarf");
            System.out.print("> ");

            Set<Integer> nombres = new HashSet<>(); // pour éviter les doublons

            System.out.println("choose 3 different numbers between [1, 2, 3, 4]");

            while (nombres.size() < 3) {
                System.out.print("First number (" + (nombres.size() + 1) + "/3) : ");

                if (sc.hasNextInt()) {
                    int n = sc.nextInt();

                    if (n >= 1 && n <= 4) {
                        if (nombres.contains(n)) {
                            System.out.println("This number is already choosed. Get another one !");
                        } else {
                            nombres.add(n);
                        }
                    } else {
                        System.out.println("This number must be between 1 et 4 !");
                    }
                } else {
                    System.out.println("Error : get another number !");
                    sc.next(); // vider la mauvaise entrée
                }
            }

            //System.out.println("\n Team : "+team_name1+" Types : "+ nombres);
            // Conversion du Set en List
            List<Integer> liste = new ArrayList<>(nombres);

            //String second = sc.nextLine();

            //System.out.println("Enter th");
            //System.out.print("> ");
            //String third = sc.nextLine();

            // Création de l'
            //Player player1 = new Player(team_name1,true,);


            // Display the strings
            System.out.println("\nTeam :"+team_name1);
            System.out.println("Types : ");
            System.out.println(" " + liste.get(0));
            System.out.println(" " + liste.get(1));
            System.out.println(" " + liste.get(2));



            playAgain = askPlayAgain();

            sc.close();
        } while (playAgain);
        System.out.println("Merci d'avoir joué — à bientôt !");
        sc.close();
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
