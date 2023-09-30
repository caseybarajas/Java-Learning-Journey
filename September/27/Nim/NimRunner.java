/*
 * Casey Barajas
 * The Game of Nim Project
 * Nim Runner class
 * 9/27/23
 * 
 * This class contains the main method to run the Game of Nim.
 * It creates an instance of the Nim class and calls the play method to start the game.
 */

public class NimRunner {
    public static void main(String[] args) throws InterruptedException {
        Nim gameOfNim = new Nim();
        gameOfNim.play(); // Play the game
    }
}
