/*
 * The Player class represents a player in the game. It can be either a human player or a computer player.
 * Each player has a symbol and can choose a spot on the board to place their symbol.
 * The Player class also provides a method to retrieve the player's symbol.
 * 
 * Player.java
 * 
 * Casey Barajas
 * 02/16/2024
 * 
 */

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
                    scanner.next(); // this is FUCKING important!
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
