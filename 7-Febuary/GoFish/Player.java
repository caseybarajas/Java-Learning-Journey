import java.util.Scanner;

public class Player {
    private char symbol;
    private boolean isHuman;

    public Player(boolean isHuman, char symbol) {
        this.isHuman = isHuman;
        this.symbol = symbol;
    }

    public int chooseSpot(Board board) {
        if (isHuman) {
            Scanner scanner = new Scanner(System.in);
            int choice;
            do {
                System.out.println("Choose a spot (1-9): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("That's not a number. Please enter a number between 1 and 9: ");
                    scanner.next(); // this is important!
                }
                choice = scanner.nextInt();
            } while (choice < 1 || choice > 9 || !board.setSymbol(choice, symbol));
            return choice;
        } else {
            // Simple AI for computer
            int spot;
            do {
                spot = (int) (Math.random() * 9) + 1;
            } while (!board.setSymbol(spot, symbol));
            System.out.println("Computer chose: " + spot);
            return spot;
        }
    }

    public char getSymbol() {
        return symbol;
    }
}
