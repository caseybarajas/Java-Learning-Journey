/*
 * Casey Barajas
 * 10/03/23
 * Arcade Game
 * Arcade.java
 * Main class to run the arcade application. Allows the user to choose 
 * from various games or exit the application. Handles user interaction 
 * and game selection.
 */

import java.util.Scanner;

public class Arcade {
    private User user;

    public Arcade(String userName) {
        this.user = new User(userName);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String userChoice;
        do {
            System.out.println("Welcome to the Arcade, " + user.getName() + "!");
            System.out.println("Choose a game to play:");
            System.out.println("1. Number Guesser");
            System.out.println("2. Math Game");
            System.out.println("3. Rock, Paper, Scissors");
            System.out.println("4. Blackjack");
            System.out.println("5. Exit");
            userChoice = scanner.nextLine();

            switch(userChoice) {
                case "1":
                    // Start NumberGuesser game
                    NumberGuesser numberGuesser = new NumberGuesser(user, -100, 100);
                    numberGuesser.play();
                    break;
                case "2":
                    // Start MathGame
                    MathGame mathGame = new MathGame(user);
                    mathGame.play();
                    break;
                case "3":
                    // Start RockPaperScissors
                    RockPaperScissors rockPaperScissors = new RockPaperScissors(user);
                    rockPaperScissors.play();
                    break;
                case "4":
                    // Start Blackjack
                    Blackjack blackjack = new Blackjack(user);
                    blackjack.play();
                    break;
                case "5":
                    // Exit
                    System.out.println("Thanks for playing!");
                    System.out.println(user.toString());  // Display user's and computer's scores
                    break;
                default:
                    System.out.println("Invalid choice. Please select a number between 1 and 5.");
                    break;
            }
        } while (!userChoice.equals("5"));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String userName = scanner.nextLine();
        Arcade arcade = new Arcade(userName);
        arcade.start();
    }
}
