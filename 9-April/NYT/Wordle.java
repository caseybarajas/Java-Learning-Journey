import java.util.Random;
import java.util.Scanner;

public class Wordle extends BaseGame {
    private static final String[] WORDS = {"ARRAY", "CACHE", "CLASS", "DEBUG", "EVENT", "FRAME", "GRAPH", "HEAPS", "INDEX", "JAVAW", "KERNEL", "LOGIC", "METHOD", "OBJECT", "PANEL", "QUEUE", "RECUR", "STACK", "TABLE", "VALUE", "WINDOW", "YIELD", "ZEROS"};
    private String selectedWord;
    private int remainingTries;

    public Wordle() {
        super("Wordle");
    }

    @Override
    public void play() {
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
            } else if (selectedWord.indexOf(inputChar) != -1) {
                guess[i] = '?';
            }
        }
    }
}