/*
* Casey Barajas
* 10/6/23
* WordleGame.java
* This file implements a simplified version of the "Wordle" game. 
* The user is prompted to guess a secret 5-letter word. After each guess, 
* the user receives feedback indicating which letters are correct and in 
* the correct position, which letters are correct but in the wrong position, 
* and which letters are incorrect. The user has 6 attempts to guess the word correctly.
*/

import java.util.Scanner;

public class WordleGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String secretWord = "apple"; // Choose the secret word

        int maxAttempts = 6;
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.println("Guess the 5-letter word:");
            String userGuess = scanner.next();

            // Validate user input
            if (userGuess.length() != 5 || !isAlpha(userGuess)) {
                System.out.println("Invalid input. Please enter a 5-letter word.");
                continue;
            }

            String feedback = "";

            // Compare and generate feedback
            for (int i = 0; i < secretWord.length(); i++) {
                char secretChar = secretWord.charAt(i);
                char guessChar = userGuess.charAt(i);

                if (secretChar == guessChar) {
                    feedback += secretChar;  // a. Correct letter and position
                } else if (secretWord.indexOf(guessChar) != -1) {
                    feedback += "*";  // b. Correct letter, wrong position
                } else {
                    feedback += "-";  // c. Incorrect letter
                }
            }

            System.out.println("Feedback: " + feedback);

            if (secretWord.equals(userGuess)) {
                System.out.println("Congratulations! You guessed the word!");
                return;
            } else {
                System.out.println("Try again. Attempts left: " + (maxAttempts - attempt));
            }
        }

        // Reveal the word after 6 unsuccessful attempts
        System.out.println("Sorry, you did not guess the word. The secret word was: " + secretWord);
    }

    // Validate that a string only contains letters
    private static boolean isAlpha(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }
}
