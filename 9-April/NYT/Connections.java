import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.stream.Collectors;

public class Connections extends BaseGame {
    private static final int NUM_CATEGORIES = 4;
    private static final int NUM_WORDS_PER_CATEGORY = 4;
    private List<String>[] categories;
    private String[] themes;
    private List<String> grid;
    private boolean[] solvedCategories;

    // ANSI escape codes for color and formatting
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_CYAN = "\u001B[36m";

    public Connections() {
        super("Connections");
        initializeCategories();
        initializeThemes();
        initializeGrid();
        solvedCategories = new boolean[NUM_CATEGORIES];
    }

    @SuppressWarnings("unchecked")
    private void initializeCategories() {
        categories = new List[NUM_CATEGORIES];
        for (int i = 0; i < NUM_CATEGORIES; i++) {
            categories[i] = new ArrayList<>();
        }

        // Example categories and words
        categories[0].add("Ruby");
        categories[0].add("Coral");
        categories[0].add("Java");
        categories[0].add("Python");

        categories[1].add("Diamond");
        categories[1].add("Emerald");
        categories[1].add("Jade");
        categories[1].add("Garnet");

        categories[2].add("Monitor");
        categories[2].add("Keyboard");
        categories[2].add("Mouse");
        categories[2].add("Printer");

        categories[3].add("CPU");
        categories[3].add("GPU");
        categories[3].add("RAM");
        categories[3].add("SSD");
    }

    private void initializeThemes() {
        themes = new String[]{
            "Programming Languages",
            "Gems",
            "Computer Peripherals",
            "Computer Components"
        };
    }

    private void initializeGrid() {
        grid = new ArrayList<>();
        for (List<String> category : categories) {
            grid.addAll(category);
        }
        shuffle();
    }

    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);
        int tries = 0;

        System.out.println(ANSI_CYAN + "Welcome to the Connections game!" + ANSI_RESET);
        System.out.println("Connect words into categories.");

        while (!allCategoriesSolved() && tries < 4) {
            displayGrid();
            System.out.println("\n"); // clear screen
            System.out.println("Choose an option:");
            System.out.println("1. Solve");
            System.out.println("2. Shuffle");
            System.out.println("3. Show solved categories");
            int option = -1;
            try {
                option = scanner.nextInt();
                scanner.nextLine(); // consume newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // consume invalid input
                continue;
            }

            if (option == 2) {
                shuffle();
                continue;
            }

            if (option == 3) {
                showSolved();
                continue;
            }

            System.out.println("Enter 4 words to form a category:");
            String[] guess = new String[NUM_WORDS_PER_CATEGORY];
            try {
                guess = scanner.nextLine().split(" ");
                if (guess.length != NUM_WORDS_PER_CATEGORY) {
                    System.out.println("Please enter exactly 4 words.");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("An error occurred. Please try again.");
                continue;
            }

            int categoryIndex = isCorrectGuess(guess);
            if (categoryIndex != -1 && !solvedCategories[categoryIndex]) {
                System.out.println(ANSI_GREEN + "Congratulations! You guessed the category correctly." + ANSI_RESET);
                solvedCategories[categoryIndex] = true;
                moveCategoryToTop(categoryIndex);
                displayCategory(categoryIndex);
            } else {
                System.out.println("Incorrect guess. Try again.");
            }
            tries++;
            System.out.println("You have " + (4 - tries) + " tries left.");
        }

        if (allCategoriesSolved()) {
            System.out.println(ANSI_GREEN + "Congratulations! You solved all the categories." + ANSI_RESET);
        } else {
            System.out.println("You have used all your tries. Better luck next time!");
        }
    }

    private void displayGrid() {
        System.out.println("\n"); // clear screen
        for (int i = 0; i < grid.size(); i++) {
            System.out.printf("%-15s", grid.get(i));
            if ((i + 1) % NUM_WORDS_PER_CATEGORY == 0) {
                System.out.println();
            }
        }
    }

    private int isCorrectGuess(String[] guess) {
        List<String> lowerCaseGuess = Arrays.stream(guess)
                                            .map(String::toLowerCase)
                                            .collect(Collectors.toList());
        for (int i = 0; i < NUM_CATEGORIES; i++) {
            List<String> lowerCaseCategory = categories[i].stream()
                                                          .map(String::toLowerCase)
                                                          .collect(Collectors.toList());
            if (lowerCaseCategory.containsAll(lowerCaseGuess)) {
                return i;
            }
        }
        return -1;
    }

    private boolean allCategoriesSolved() {
        for (boolean solved : solvedCategories) {
            if (!solved) {
                return false;
            }
        }
        return true;
    }

    private void showSolved() {
        System.out.println("Solved categories:");
        for (int i = 0; i < NUM_CATEGORIES; i++) {
            if (solvedCategories[i]) {
                System.out.println("- " + themes[i]);
            }
        }
    }

    private void moveCategoryToTop(int categoryIndex) {
        List<String> category = categories[categoryIndex];
        grid.removeAll(category);
        // Do not add the category back to the grid
    }

    private void displayCategory(int categoryIndex) {
        System.out.println("Category: " + themes[categoryIndex]);
        for (String word : categories[categoryIndex]) {
            System.out.println("- " + word);
        }
    }

    public void shuffle() {
        Collections.shuffle(grid);
    }

    public static void main(String[] args) {
        Connections game = new Connections();
        game.shuffle();
        game.play();
    }
}
