/*
 * Casey Barajas
 * 10/03/23
 * Arcade Game
 * Blackjack.java
 * A simplified version of Blackjack where the user and the computer (dealer)
 * are dealt cards, and the user decides whether to hit or stand in an effort 
 * to have the highest value hand without exceeding 21. The user's and 
 * computer's scores are updated based on the outcome of each round.
 */

import java.util.Random;
import java.util.Scanner;

public class Blackjack {
    private User user;

    public Blackjack(User user) {
        this.user = user;
    }

    private int dealCard() {
        Random rand = new Random();
        // Values 1 through 11 (representing Ace through 10 and face cards)
        return rand.nextInt(11) + 1;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        int playerScore = dealCard() + dealCard();
        int dealerScore = dealCard() + dealCard();

        System.out.println("Welcome to Blackjack!");
        System.out.println("Your score: " + playerScore);
        System.out.println("Dealer's visible card: " + dealerScore / 2);  // Simplification

        while (playerScore < 21) {
            System.out.println("Do you want to 'hit' or 'stand'?");
            String userChoice = scanner.nextLine().toLowerCase();
            if (userChoice.equals("hit")) {
                playerScore += dealCard();
                System.out.println("Your score: " + playerScore);
            } else if (userChoice.equals("stand")) {
                break;
            } else {
                System.out.println("Invalid choice. Choose 'hit' or 'stand'.");
            }
        }

        System.out.println("Dealer's score: " + dealerScore);
        while (dealerScore < 17 && playerScore <= 21) {
            dealerScore += dealCard();
            System.out.println("Dealer takes a card. Dealer's score: " + dealerScore);
        }

        if (playerScore > 21) {
            System.out.println("Bust! You lose.");
            user.incrementComputerScore();
        } else if (dealerScore > 21) {
            System.out.println("Dealer busts! You win!");
            user.incrementUserScore();
        } else if (dealerScore >= playerScore) {
            System.out.println("Dealer wins!");
            user.incrementComputerScore();
        } else {
            System.out.println("You win!");
            user.incrementUserScore();
        }
    }
}
