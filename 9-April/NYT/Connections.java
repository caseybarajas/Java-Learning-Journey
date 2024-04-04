import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Connections extends BaseGame {
    private static final int NUM_CATEGORIES = 4;
    private static final int NUM_WORDS_PER_CATEGORY = 4;
    private List<String>[] categories;
    private String[] themes;
    private int remainingAttempts;

    public Connections() {
        super("Connections");
        initializeCategories();
        initializeThemes();
    }

    @SuppressWarnings("unchecked")
    private void initializeCategories() {
        categories = new List[NUM_CATEGORIES];
        for (int i = 0; i < NUM_CATEGORIES; i++) {
            categories[i] = new ArrayList<>();
        }

        // Example categories and words
        categories[0].add("red");
        categories[0].add("blue");
        categories[0].add("green");
        categories[0].add("yellow");

        categories[1].add("apple");
        categories[1].add("banana");
        categories[1].add("orange");
        categories[1].add("grape");

        categories[2].add("dog");
        categories[2].add("cat");
        categories[2].add("bird");
        categories[2].add("fish");

        categories[3].add("car");
        categories[3].add("bike");
        categories[3].add("train");
        categories[3].add("plane");
    }

    private void initializeThemes() {
        themes = new String[]{
            "Colors",
            "Fruits",
            "Animals",
            "Transportation"
        };
    }

    @Override
    public void play() {
        remainingAttempts = 4;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Connections!");
        System.out.println("Guess the common theme that connects the words in each category.");

        while (remainingAttempts > 0) {
            displayCategories();
            System.out.println("Remaining attempts: " + remainingAttempts);
            System.out.print("Enter your guess: ");
            String guess = scanner.nextLine();

            if (isCorrectGuess(guess)) {
                System.out.println("Congratulations! You guessed the theme correctly.");
                score = remainingAttempts;
                break;
            } else {
                remainingAttempts--;
                System.out.println("Incorrect guess. Try again.");
            }
        }

        if (remainingAttempts == 0) {
            System.out.println("Game over! The correct themes were:");
            displayThemes();
            System.out.print("Do you want to see the solution? (yes/no): ");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                displaySolution();
            }
        }
    }

    private void displayCategories() {
        for (int i = 0; i < NUM_CATEGORIES; i++) {
            System.out.println("Category " + (i + 1) + ":");
            for (int j = 0; j < NUM_WORDS_PER_CATEGORY; j++) {
                System.out.println("- " + categories[i].get(j));
            }
            System.out.println();
        }
    }

    private boolean isCorrectGuess(String guess) {
        for (String theme : themes) {
            if (guess.equalsIgnoreCase(theme)) {
                return true;
            }
        }
        return false;
    }

    private void displayThemes() {
        for (int i = 0; i < NUM_CATEGORIES; i++) {
            System.out.println("Category " + (i + 1) + ": " + themes[i]);
        }
    }

    private void displaySolution() {
        System.out.println("Solution:");
        for (int i = 0; i < NUM_CATEGORIES; i++) {
            System.out.println("Category " + (i + 1) + " (" + themes[i] + "):");
            for (int j = 0; j < NUM_WORDS_PER_CATEGORY; j++) {
                System.out.println("- " + categories[i].get(j));
            }
            System.out.println();
        }
    }

    public void shuffle() {
        for (List<String> category : categories) {
            Collections.shuffle(category);
        }
    }
}