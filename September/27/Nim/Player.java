/*
 * Casey Barajas
 * The Game of Nim Project
 * Player class
 * 9/27/23
 * 
 * This class represents a human player in the game. It keeps track of the 
 * player's name and provides a method for the player to take a turn by 
 * removing a valid number of pieces from the board.
 */


import java.util.Scanner;

public class Player implements GameParticipant {
    private String name;
    private Scanner scanner = new Scanner(System.in);
    
    public Player(String n) {
        this.name = n;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public int takeTurn(int pieces) {
        int maxPieces = pieces / 2;
        int chosenPieces = 0;
        do {
            System.out.println(name + ", enter the number of pieces to remove (1 to " + maxPieces + "):");
            try {
                chosenPieces = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        } while (chosenPieces < 1 || chosenPieces > maxPieces);
        return chosenPieces;
    }
}
