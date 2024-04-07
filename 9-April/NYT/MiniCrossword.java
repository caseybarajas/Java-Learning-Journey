import java.util.Scanner;
import java.util.Random;

public class MiniCrossword extends BaseGame {

    private static final int SIZE = 5;
    private static final int MAX_GUESSES = 5;
    private char[][] grid;
    private String[] acrossClues;
    private String[] downClues;
    private long startTime;
    private long endTime;
    private int guessesRemaining;
    // ANSI escape codes for colors
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";

    public MiniCrossword() {
        super("Mini Crossword");
        grid = new char[SIZE][SIZE];
        initializeGrid();
        initializeClues();
    }

    private void initializeGrid() {
        // Initialize the grid with empty cells
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                grid[row][col] = ' ';
            }
        }

    }

    private void initializeClues() {
        acrossClues = new String[5];
        acrossClues[0] = "1. Fluffs up";
        acrossClues[1] = "2. Fruit with a core";
        acrossClues[2] = "3. Tie again";
        acrossClues[3] = "4. Halloween prank";
        acrossClues[4] = "5. Pulls hard";

        downClues = new String[5];
        downClues[0] = "1. Celebration";
        downClues[1] = "2. Musical drama";
        downClues[2] = "3. Agree to join";
        downClues[3] = "4. Quick, light blow";
        downClues[4] = "5. Searches for";
    }

    @Override
    public void play() {
        startTime = System.currentTimeMillis();
        displayGrid();
        displayClues();
        Scanner scanner = new Scanner(System.in);
        while (!isGridFilled()) {
            System.out.println("1. Show hints");
            System.out.println("2. Solve");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                showHint();
            } else if (choice == 2) {
                System.out.print("Enter the row (1-5): ");
                int row = scanner.nextInt() - 1;
                System.out.print("Enter the column (1-5): ");
                int col = scanner.nextInt() - 1;
                if (isValidCell(row, col)) {
                    guessesRemaining = MAX_GUESSES;
                    char correctLetter = getCorrectLetter(row, col);
                    while (guessesRemaining > 0) {
                        System.out.print("Enter the letter (Guesses remaining: " + guessesRemaining + "): ");
                        char letter = scanner.next().charAt(0);
                        if (Character.toUpperCase(letter) == correctLetter) {
                            grid[row][col] = correctLetter;
                            displayGrid();
                            displayRemainingTime();
                            break;
                        } else {
                            guessesRemaining--;
                            System.out.println("Incorrect letter. Try again.");
                        }
                    }
                    if (guessesRemaining == 0) {
                        System.out.println("No more guesses remaining. Moving on to the next cell.");
                    }
                } else {
                    System.out.println("Invalid cell. Please try again.");
                }
            }
        }
        endTime = System.currentTimeMillis();
        long elapsedTime = (endTime - startTime) / 1000; // Convert to seconds
        if (checkSolution()) {
            System.out.println("Congratulations! You solved the mini crossword.");
            System.out.println("Time taken: " + elapsedTime + " seconds");
            score = (int) (SIZE * SIZE * 10 / elapsedTime); // Calculate score based on time
        } else {
            System.out.println("Sorry, your solution is incorrect.");
            System.out.println("Time taken: " + elapsedTime + " seconds");
            score = 0;
        }
    }

    private void showHint() {
            displayClues();
    }

    private void displayGrid() {
        System.out.println("Mini Crossword Grid:");
        System.out.println("  1 2 3 4 5");
        for (int row = 0; row < SIZE; row++) {
            System.out.print((row + 1) + " ");
            for (int col = 0; col < SIZE; col++) {
                if (grid[row][col] == ' ') {
                    System.out.print(ANSI_RED + grid[row][col] + ANSI_RESET + " ");
                } else {
                    System.out.print(ANSI_GREEN + grid[row][col] + ANSI_RESET + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private void displayClues() {
        System.out.println("Across Clues:");
        for (int i = 0; i < acrossClues.length; i++) {
            System.out.println(acrossClues[i]);
        }
        System.out.println();
        System.out.println("Down Clues:");
        for (int i = 0; i < downClues.length; i++) {
            System.out.println(downClues[i]);
        }
        System.out.println();
    }

    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < SIZE && col >= 0 && col < SIZE;
    }

    private boolean isGridFilled() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (grid[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private void displayRemainingTime() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = (currentTime - startTime) / 1000; // Convert to seconds
        System.out.println("Time elapsed: " + elapsedTime + " seconds");
        System.out.println();
    }

    private boolean checkSolution() {
        String[] acrossAnswers = {"POOFS", "APPLE", "RETIE", "TRICK", "YANKS"};
        String[] downAnswers = {"PARTY", "OPERA", "OPTIN", "FLICK", "SEEKS"};
        for (int i = 0; i < acrossAnswers.length; i++) {
            String word = getWord(i, true);
            if (!word.equals(acrossAnswers[i])) {
                return false;
            }
        }
        for (int i = 0; i < downAnswers.length; i++) {
            String word = getWord(i, false);
            if (!word.equals(downAnswers[i])) {
                return false;
            }
        }
        return true;
    }

    private char getCorrectLetter(int row, int col) {
        String[] acrossAnswers = {"POOFS", "APPLE", "RETIE", "TRICK", "YANKS"};
        String[] downAnswers = {"PARTY", "OPERA", "OPTIN", "FLICK", "SEEKS"};

        // Check the across and down answers for the correct letter
        char correctLetter = ' ';
        if (row < acrossAnswers.length && col < acrossAnswers[row].length()) {
            correctLetter = acrossAnswers[row].charAt(col);
        } else if (col < downAnswers.length && row < downAnswers[col].length()) {
            correctLetter = downAnswers[col].charAt(row);
        }

        return correctLetter;
    }

    private String getWord(int index, boolean isAcross) {
        // Only decrement index if it's greater than 0
        if (index > 0) {
            index--;  // Convert to 0-based index
        }
    
        if (isAcross) {
            int row = getRowForAcrossWord(index);
            int startCol = getColForAcrossWord(index);
            int length = getAcrossAnswers()[index].length();
            StringBuilder word = new StringBuilder();
            for (int col = startCol; col < startCol + length; col++) {
                word.append(grid[row][col]);
            }
            return word.toString();
        } else {
            int col = getColForDownWord(index);
            int startRow = getRowForDownWord(index);
            int length = getDownAnswers()[index].length();
            StringBuilder word = new StringBuilder();
            for (int row = startRow; row < startRow + length; row++) {
                word.append(grid[row][col]);
            }
            return word.toString();
        }
    }

    private int getRowForAcrossWord(int index) {
        switch (index) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            default:
                return -1;
        }
    }

    private int getColForAcrossWord(int index) {
        return index;
    }

    private int getRowForDownWord(int index) {
        return index;
    }

    private int getColForDownWord(int index) {
        switch (index) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            default:
                return -1;
        }
    }

    private String[] getAcrossAnswers() {
        return new String[]{"POOFS", "APPLE", "RETIE", "TRICK", "YANKS"};
    }

    private String[] getDownAnswers() {
        return new String[]{"PARTY", "OPERA", "OPTIN", "FLICK", "SEEKS"};
    }
}
