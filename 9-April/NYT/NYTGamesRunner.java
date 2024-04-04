import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class NYTGamesRunner {
    private List<Game> gamesPlayed;
    private int totalScore;

    public NYTGamesRunner() {
        gamesPlayed = new ArrayList<>();
        totalScore = 0;
    }

    public void run() {
        displayWelcomeMessage();

        boolean playAgain = true;
        Scanner scanner = new Scanner(System.in);

        while (playAgain) {
            displayGameMenu();
            int choice = scanner.nextInt();

            Game selectedGame = null;
            switch (choice) {
                case 1:
                    selectedGame = new Wordle();
                    break;
                case 2:
                    selectedGame = new MiniCrossword();
                    break;
                case 3:
                    selectedGame = new Connections();
                    break;
                case 4:
                    selectedGame = new WordSearch();
                    break;
                case 5:
                    playAgain = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            if (selectedGame != null) {
                selectedGame.play();
                gamesPlayed.add(selectedGame);
                totalScore += selectedGame.getScore();
            }
        }

        displayStats();
    }

    private void displayWelcomeMessage() {
        String currentDate = new SimpleDateFormat("EEEE, MMMM d, yyyy").format(new Date());
        System.out.println("Welcome to New York Times Games!");
        System.out.println("Today is " + currentDate);
        System.out.println();
    }

    private void displayGameMenu() {
        System.out.println("Select a game to play:");
        System.out.println("1. Wordle");
        System.out.println("2. Mini Crossword");
        System.out.println("3. Connections");
        System.out.println("4. Word Search");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void displayStats() {
        System.out.println("Game Stats:");
        System.out.println("Total Score: " + totalScore);
        System.out.println("Games Played:");
        for (Game game : gamesPlayed) {
            System.out.println("- " + game.getName() + ": " + game.getScore() + " points");
        }
    }

    public static void main(String[] args) {
        NYTGamesRunner runner = new NYTGamesRunner();
        runner.run();
    }
}