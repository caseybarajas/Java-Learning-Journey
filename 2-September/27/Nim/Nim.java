/*
 * Casey Barajas
 * The Game of Nim Project
 * Nim class
 * 9/27/23
 * 
 * This class represents the Game of Nim. It initializes the players, 
 * sets up the game board, and contains the game loop where players 
 * take turns until the game ends. It also handles user inputs for 
 * game settings and replaying the game.
 */

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Nim {
    private Scanner scan = new Scanner(System.in);
    private GameParticipant player1;
    private GameParticipant player2;
    private boolean isComputerOpponent;
    private boolean isCheatComputer;
    
    private int player1Score = 0;
    private int player2Score = 0;
    
    public Nim() throws InterruptedException {
        System.out.println("Enter Player 1 name:");
        String input = scan.nextLine();
        player1 = new Player(input);
        
        System.out.println("Do you want to play against the computer? (yes/no)");
        input = scan.nextLine().toLowerCase();
        isComputerOpponent = input.equals("yes");
        
        if (isComputerOpponent) {
            System.out.println("Enable cheat mode for computer? (yes/no)");
            input = scan.nextLine().toLowerCase();
            isCheatComputer = input.equals("yes");
            player2 = new Computer(isCheatComputer);
        } else {
            System.out.println("Enter Player 2 name:");
            input = scan.nextLine();
            player2 = new Player(input);
        }

        // Countdown before the game starts
        System.out.println("Game starts in:");
        for (int i = 3; i > 0; i--) {
            System.out.println(i);
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("Go!");
    }
    
    public void play() {
        int currentPlayer = 1;
        int piecesRemoved;
        
        do {
            currentPlayer = (int) (Math.random() * 2) + 1;
            Board.populate(); // Ensure the board is populated at the beginning of each game
            
            while (Board.getPieces() > 1) {
                GameParticipant current = (currentPlayer == 1) ? player1 : player2;
                System.out.println("Current board pieces: " + Board.getPieces());
                piecesRemoved = current.takeTurn(Board.getPieces());
                Board.pieces -= piecesRemoved;
                currentPlayer = 3 - currentPlayer;
            }
            
            GameParticipant winner = (currentPlayer == 1) ? player2 : player1;
            System.out.println(winner.getName() + " wins this round!");
            
            // Update the score of the winner
            if (winner == player1) {
                player1Score++;
            } else {
                player2Score++;
            }
            
            System.out.println("Do you want to play again? (yes/no)");
            boolean playAgain = scan.nextLine().toLowerCase().equals("yes");
            if (!playAgain) {
                // Display the final scores when the user decides not to play again
                System.out.println(player1.getName() + "'s score: " + player1Score);
                System.out.println(player2.getName() + "'s score: " + player2Score);
                break;
            } else {
                Board.populate();
            }
        } while (true);
    }
}
