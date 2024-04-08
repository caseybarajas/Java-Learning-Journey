import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordSearch extends BaseGame {
    private static final int SIZE = 15;
    private char[][] grid;
    private List<String> words;
    private List<String> foundWords;
    private Random random = new Random();

    public WordSearch() {
        super("Word Search"); // Call the super class constructor with the game name
        grid = new char[SIZE][SIZE];
        words = new ArrayList<>();
        foundWords = new ArrayList<>();
        initializeWords();
        initializeGrid();
    }

    private void initializeWords() {
        words.add("ILOVEYOU");
        words.add("CodeRed");
        words.add("Stuxnet");
        words.add("Mydoom");
        words.add("Conficker");
        words.add("Sobig");
        words.add("Blaster");
        words.add("Sasser");
        words.add("Zeus");
        words.add("Slammer");
    }

    private void initializeGrid() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                grid[row][col] = (char) (random.nextInt(26) + 'A');
            }
        }

        for (String word : words) {
            boolean placed = false;
            while (!placed) {
                int direction = random.nextInt(8);
                int row = random.nextInt(SIZE);
                int col = random.nextInt(SIZE);

                if (canPlaceWord(word, row, col, direction)) {
                    placeWord(word, row, col, direction);
                    placed = true;
                }
            }
        }
    }

    private boolean canPlaceWord(String word, int row, int col, int direction) {
        int len = word.length();
        int dr = 0, dc = 0;

        switch (direction) {
            case 0: dr = -1; dc = -1; break;
            case 1: dr = -1; dc = 0; break;
            case 2: dr = -1; dc = 1; break;
            case 3: dr = 0; dc = -1; break;
            case 4: dr = 0; dc = 1; break;
            case 5: dr = 1; dc = -1; break;
            case 6: dr = 1; dc = 0; break;
            case 7: dr = 1; dc = 1; break;
        }

        int newRow = row + dr * (len - 1);
        int newCol = col + dc * (len - 1);

        if (newRow < 0 || newRow >= SIZE || newCol < 0 || newCol >= SIZE) {
            return false;
        }

        for (int i = 0; i < len; i++) {
            if (grid[row + dr * i][col + dc * i] != (char) (random.nextInt(26) + 'A')) {
                return false;
            }
        }

        return true;
    }

    private void placeWord(String word, int row, int col, int direction) {
        int len = word.length();
        int dr = 0, dc = 0;

        switch (direction) {
            case 0: dr = -1; dc = -1; break;
            case 1: dr = -1; dc = 0; break;
            case 2: dr = -1; dc = 1; break;
            case 3: dr = 0; dc = -1; break;
            case 4: dr = 0; dc = 1; break;
            case 5: dr = 1; dc = -1; break;
            case 6: dr = 1; dc = 0; break;
            case 7: dr = 1; dc = 1; break;
        }

        for (int i = 0; i < len; i++) {
            grid[row + dr * i][col + dc * i] = word.charAt(i);
        }
    }

    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Word Search!");
        System.out.println("Find the hidden computer viruses in the grid.");

        while (foundWords.size() < words.size()) {
            displayGrid();
            displayFoundWords();

            System.out.println("Options:");
            System.out.println("1. Make a guess");
            System.out.println("2. Get a hint");
            System.out.println("3. Give up");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the virus you found: ");
                    String guess = scanner.nextLine();
                    if (words.contains(guess) && !foundWords.contains(guess)) {
                        foundWords.add(guess);
                        System.out.println("Correct! Virus found.");
                        score++;
                    } else {
                        System.out.println("Invalid virus. Try again.");
                    }
                    break;
                case 2:
                    String hint = getHint();
                    System.out.println("Hint: " + hint);
                    break;
                case 3:
                    System.out.println("Game over! Here are the remaining viruses:");
                    displayRemainingWords();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Congratulations! You found all the viruses.");
        displayGrid();
        displayFoundWords();
    }

    private void displayGrid() {
        System.out.println("Word Search Grid:");
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void displayFoundWords() {
        System.out.println("Found Viruses:");
        for (String word : foundWords) {
            System.out.println("- " + word);
        }
        System.out.println();
    }

    private String getHint() {
        for (String word : words) {
            if (!foundWords.contains(word)) {
                return "The virus starts with the letter: " + word.charAt(0);
            }
        }
        return "No more hints available.";
    }

    private void displayRemainingWords() {
        for (String word : words) {
            if (!foundWords.contains(word)) {
                System.out.println("- " + word);
            }
        }
    }
}