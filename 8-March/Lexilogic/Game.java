/*
 * Lexilogic Game
 * Casey Barajas
 * 3/6/2024
 * 
 * This file contains the main class for the friucking Lexilogic game. The game is a puzzle where the player
 * needs to guess the coding language for each cell in a grid. HORRAY!
 * 
 * Im tired but lwk this works so im happy and its 1:30am so im going to bed
 * - Casey
 * 
 * lmao like 2 weeks later and i just realized i never added the debug mode to the game so i added it now
 * 
 * lmao like the debug mode is there but like it dont work, thats funny silly hahahahahahahhahaha
 * 
 * womp owmp womp womsamdjasjdashfjadsfasfkjldsakdsakjsdakjadsadfiohadfihosdiofhfeaioaihoa
 * 
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class Game {
    private static final String DEBUG_WORD = "Deeebug";
    private static boolean debugMode = false;

    public static void main(String[] args) {
        Grid grid = new Grid();
        Player player = new Player();
        Scanner input = new Scanner(System.in);
        boolean hardMode = false;

        System.out.println("Welcome to the frickin Lexilogic game birches"); // print welcome message
        System.out.println("Guess the flippin coding language for each gosh darn cell."); // print game instructions
        System.out.println("Enter the cell location like this (e.g., 'A1') and your frickin guess."); // print input format instructions

        while (true) {
            System.out.print("Enable hard mode? (y/n): "); // ask user to enable hard mode
            String hardModeChoice = input.nextLine();
            if (hardModeChoice.equalsIgnoreCase("y")) {
                hardMode = true;
                System.out.println("Mama aint raise no bi*** hard mode is frickin enabled. Game ends after 3 incorrect guesses."); // print hard mode enabled message
                break;
            } else if (hardModeChoice.equalsIgnoreCase("n")) {
                break;
            } else {
                System.out.println("Invalid input dummy. Please enter 'y' or 'n'"); // print invalid input message
            }
        }
        
        while (!grid.isSolved()) {
            try {
                System.out.println();
                grid.printGrid();
                System.out.println();
        
                String userInput = player.takeTurn();
                if (userInput.equalsIgnoreCase(DEBUG_WORD)) {
                    debugMode = true;
                    showDebugMenu(grid, input);
                } else if (userInput.equals("1")) {
                    System.out.print("Enter the cell location: "); // ask user to enter cell location
                    String location = input.nextLine().toUpperCase();
                    System.out.print("Enter your guess: "); // ask user to enter guess
                    String guess = input.nextLine();
        
                    if (grid.solveCell(location, guess)) {
                        System.out.println("Correct!"); // print correct message
                    } else {
                        System.out.println("Incorrect."); // print incorrect message
                        player.addStrike();
                    }
                } else if (userInput.equals("2")) {
                    grid.printHints();
                } else {
                    System.out.println("Invalid input. Please enter '1' or '2'."); // print invalid input message
                }
        
                if (hardMode && player.getStrikes() >= 3) {
                    System.out.println("Game over! Too many incorrect guesses."); // print game over message
                    return;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input: " + e.getMessage()); // print invalid input message
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid choice."); // print invalid input message
                input.nextLine(); // Clear the invalid input
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage()); // print error message
            }
        }
        
        System.out.println("congrats amigo, u solved the Lexilogic puzzle!"); // print congratulations message
    }

    private static void showDebugMenu(Grid grid, Scanner input) {
        while (debugMode) {
            System.out.println("\nDebug Menu:");
            System.out.println("1. Solve All Except One");
            System.out.println("2. Exit Debug Mode");
            System.out.print("Enter your choice: ");
    
            String choice = input.nextLine();
            if (choice.equals("1")) {
                solveAllExceptOne(grid);
            } else if (choice.equals("2")) {
                debugMode = false;
                System.out.println("Exiting debug mode."); // print exit debug mode message
            } else {
                System.out.println("Invalid choice. Please try again."); // print invalid choice message
            }
        }
    }
    
    private static void solveAllExceptOne(Grid grid) {
        int unsolvedCount = 0;
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                if (!grid.isSolved(row, col)) {
                    if (unsolvedCount == 0) {
                        unsolvedCount++;
                    } else {
                        String location = String.valueOf((char) ('A' + row)) + (col + 1);
                        String word = grid.getCell(row, col).showWord();
                        grid.solveCell(location, word);
                    }
                }
            }
        }
        System.out.println("All cells except one have been solved."); // print all cells solved message
    }
}