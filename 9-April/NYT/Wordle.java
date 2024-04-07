import java.util.Random;
import java.util.Scanner;

public class Wordle extends BaseGame {
    private static final String[] WORDS = {"ARRAY", "CACHE", "CLASS", "DEBUG", "EVENT", "FRAME", "GRAPH", "HEAPS", "INDEX", "LOGIC", "PANEL", "QUEUE", "STACK", "TABLE", "VALUE", "YIELD", "ZEROS"};
    private String selectedWord;
    private int remainingTries;
    private boolean hardMode;

    public Wordle() {
        super("Wordle");
    }

@Override
public void play() {
    chooseMode();
    selectRandomWord();
    remainingTries = 6;
    Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Wordle!");
        System.out.println("Guess the five-letter word related to computers.");

        char[] guess = new char[5];
        for (int i = 0; i < 5; i++) {
            guess[i] = '_';
        }

        while (remainingTries > 0) {
            displayGuess(guess);
            System.out.print("Enter your guess: ");
            String input = scanner.nextLine().toUpperCase();

            if (input.length() != 5) {
                System.out.println("Invalid guess. Please enter a five-letter word.");
                continue;
            }

            if (input.equals(selectedWord)) {
                System.out.println("Congratulations! You guessed the word correctly.");
                score = remainingTries;
                displayGuess(selectedWord.toCharArray());
                break;
            } else {
                remainingTries--;
                updateGuess(guess, input);
                System.out.println("Incorrect guess. Remaining tries: " + remainingTries);
            }
        }

        if (remainingTries == 0) {
            System.out.println("Game over! The word was: " + selectedWord);
        }
    }

    private void chooseMode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your mode: 1 for standard, 2 for hard");
        int mode = scanner.nextInt();
        hardMode = mode == 2;
    }

    private void selectRandomWord() {
        Random random = new Random();
        int index = random.nextInt(WORDS.length);
        selectedWord = WORDS[index];
    }

    private void displayGuess(char[] guess) {
        for (char c : guess) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    private void updateGuess(char[] guess, String input) {
        for (int i = 0; i < 5; i++) {
            char inputChar = input.charAt(i);
            if (inputChar == selectedWord.charAt(i)) {
                guess[i] = inputChar;
                System.out.print("\u001B[32m" + guess[i] + " "); // Green for correct letters
            } else if (!hardMode && selectedWord.indexOf(inputChar) != -1) {
                guess[i] = '?';
                System.out.print("\u001B[33m" + guess[i] + " "); // Yellow for present but misplaced letters
            } else {
                System.out.print("\u001B[0m" + guess[i] + " "); // Reset color for other letters
            }
        }
        System.out.println("\u001B[0m"); // Reset color after printing the guess
    }
}