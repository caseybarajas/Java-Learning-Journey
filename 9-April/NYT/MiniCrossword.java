import java.util.Scanner;

public class MiniCrossword extends BaseGame {
    private static final int SIZE = 5;
    private static final int MAX_GUESSES = 5;
    private char[][] grid;
    private String[] acrossClues;
    private String[] downClues;
    private long startTime;
    private long endTime;
    private int guessesRemaining;

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
        // Initialize the across clues
        acrossClues = new String[5];
        acrossClues[0] = "1. Frozen dwelling";
        acrossClues[1] = "2. Large feline";
        acrossClues[2] = "3. Citrus fruit";
        acrossClues[3] = "4. Stringed instrument";
        acrossClues[4] = "5. Precious stone";

        // Initialize the down clues
        downClues = new String[5];
        downClues[0] = "1. Elephant tusk material";
        downClues[1] = "2. West African country";
        downClues[2] = "3. Metric unit of volume";
        downClues[3] = "4. Chinese tea variety";
        downClues[4] = "5. Breakfast cereal grain";
    }

    @Override
    public void play() {
        startTime = System.currentTimeMillis();
        displayGrid();
        displayClues();

        Scanner scanner = new Scanner(System.in);

        while (!isGridFilled()) {
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

    private void displayGrid() {
        System.out.println("Mini Crossword Grid:");
        System.out.println("  1 2 3 4 5");
        for (int row = 0; row < SIZE; row++) {
            System.out.print((row + 1) + " ");
            for (int col = 0; col < SIZE; col++) {
                System.out.print(grid[row][col] + " ");
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
        // Check the words in the grid against the correct answers
        String[] acrossAnswers = {"IGLOO", "TIGER", "LEMON", "VIOLA", "PEARL"};
        String[] downAnswers = {"IVORY", "GHANA", "LITER", "OOLONG", "OATS"};

        // Check the across words
        for (int i = 0; i < acrossAnswers.length; i++) {
            String word = getWord(i, true);
            if (!word.equals(acrossAnswers[i])) {
                return false;
            }
        }

        // Check the down words
        for (int i = 0; i < downAnswers.length; i++) {
            String word = getWord(i, false);
            if (!word.equals(downAnswers[i])) {
                return false;
            }
        }

        return true;
    }

    private char getCorrectLetter(int row, int col) {
        String[] acrossAnswers = {"IGLOO", "TIGER", "LEMON", "VIOLA", "PEARL"};
        String[] downAnswers = {"IVORY", "GHANA", "LITER", "OOLONG", "OATS"};

        // Check if the letter belongs to an across word
        for (int i = 0; i < acrossAnswers.length; i++) {
            if (row == i && col < SIZE) {
                return acrossAnswers[i].charAt(col);
            }
        }

        // Check if the letter belongs to a down word
        for (int i = 0; i < downAnswers.length; i++) {
            if (col == i && row < SIZE) {
                return downAnswers[i].charAt(row);
            }
        }

        return ' ';
    }

    private String getWord(int index, boolean isAcross) {
        if (isAcross) {
            StringBuilder word = new StringBuilder();
            for (int col = 0; col < SIZE; col++) {
                word.append(grid[index][col]);
            }
            return word.toString();
        } else {
            StringBuilder word = new StringBuilder();
            for (int row = 0; row < SIZE; row++) {
                word.append(grid[row][index]);
            }
            return word.toString();
        }
    }
}