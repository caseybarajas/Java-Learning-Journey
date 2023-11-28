/*
 * Casey Barajas
 * 10/03/23
 * Arcade Game
 * RockPaperScissors.java
 * A classic Rock, Paper, Scissors game where the user and computer randomly 
 * choose one of the three options. The winner is decided based on the 
 * classic game rules, and the corresponding score is incremented.
 */

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private User user;
    private String computerChoice;

    public RockPaperScissors(User user) {
        this.user = user;
        String[] choices = {"rock", "paper", "scissors"};
        Random rand = new Random();
        computerChoice = choices[rand.nextInt(choices.length)];
    }

    private String getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        String userChoice;
        while (true) {
            System.out.println("Choose rock, paper, or scissors:");
            userChoice = scanner.nextLine().toLowerCase();
            if (userChoice.equals("rock") || userChoice.equals("paper") || userChoice.equals("scissors")) {
                break;
            } else {
                System.out.println("Invalid choice. Please choose rock, paper, or scissors.");
            }
        }
        return userChoice;
    }

    private void determineWinner(String userChoice) {
        System.out.println("Computer chose: " + computerChoice);
        if (userChoice.equals(computerChoice)) {
            System.out.println("It's a tie!");
        } else if (
                (userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                (userChoice.equals("scissors") && computerChoice.equals("paper"))
        ) {
            System.out.println("You win!");
            user.incrementUserScore();
        } else {
            System.out.println("You lose!");
            user.incrementComputerScore();
        }
    }

    public void play() {
        String userChoice = getUserChoice();
        determineWinner(userChoice);
    }
}
