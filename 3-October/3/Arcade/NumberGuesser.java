/*
 * Casey Barajas
 * 10/03/23
 * Arcade Game
 * NumberGuesser.java
 * Simple number guessing game where the computer selects a random number
 * and the user attempts to guess it. Provides feedback on whether the guess
 * is too high or too low, and allows the user to continue guessing until
 * they decide to exit the game.
 */

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {
    private int secretNumber;
    private User user;
    private int lowerBound;
    private int upperBound;

    public NumberGuesser(User user, int lowerBound, int upperBound) {
        Random rand = new Random();
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        secretNumber = rand.nextInt(upperBound - lowerBound + 1) + lowerBound;
        this.user = user;
    }

    public void getUserGuess() {
        Scanner scanner = new Scanner(System.in);
        int userGuess;
        int attempts = 0;
        int maxAttempts = 5; // Max attempts allowed

        System.out.println("Guess a number between " + lowerBound + " and " + upperBound);
        while(true) {
            System.out.println("Enter your guess: ");
            try {
                userGuess = Integer.parseInt(scanner.nextLine());
                attempts++;
                if(userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the right number.");
                    user.incrementUserScore();
                    break;
                } else if(userGuess > secretNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }

                if(attempts >= maxAttempts) {
                    System.out.println("Too many attempts. The correct number was: " + secretNumber);
                    user.incrementComputerScore();
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public void play() {
        getUserGuess();
    }
}
