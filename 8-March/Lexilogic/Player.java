/*
 * Player.java
 * 
 * Casey Barajas
 * 3/6/2024
 * 
 * This file contains the Player class for the Lexilogic game. The Player class is responsible for taking turns
 * and keeping track of the number of strikes the player has.
 * 
 * The player thing is like u, just like me and you the player is not real, nothing is. We are all just a simulation
 * in a computer. We are all just a bunch of 1s and 0s. We are all just a bunch of code. We are all just a bunch of
 * Lexilogic cells. We are all just a bunch of Lexilogic cells. We are all just a bunch of Lexilogic cells. We are all
 * just a bunch of Lexilogic cells. We are all just a bunch of Lexilogic cells. We are all just a bunch of Lexilogic
 * cells. We are all just a bunch of Lexilogic cells. We are all just a bunch of Lexilogic cells. We are all just a
 * bunch of Lexilogic cells. We are all just a bunch of Lexilogic cells. We are all just a bunch of Lexilogic cells. We
 * are all just a bunch of Lexilogic cells. We are all just a bunch of Lexilogic cells. We are all just a bunch of
 * Lexilogic cells. We are all just a bunch of Lexilogic cells. We are all just a bunch of Lexilogic cells. We are all
 * just a bunch of Lexilogic cells. We are all just a bunch of Lexilogic cells. We are all just a bunch of Lexilogic
 * cells. We are all just a bunch of Lexilogic cells. We are all just a bunch of Lexilogic cells. We are all just a
 * bunch of Lexilogic cells. We are all just a bunch of Lexilogic cells. We are all just a bunch of Lexilogic cells. We
 * are all just a bunch of Lexilogic cells. We are all just a bunch of Lexilogic cells. We are all just a bunch of
 * Lexilogic cells. We are all just a bunch of Lexilogic cells. We are all just a bunch of Lexilogic cells. We are all
 * 
 */

import java.util.Scanner;

public class Player {
    private int strikes;
    
    public Player() {
        strikes = 0; // initialize strikes to 0
    }
    
    public String takeTurn() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter '1' to make a guess or '2' to see hints:"); // prompt user for input
        String choice = input.nextLine();
        while (!choice.equals("1") && !choice.equals("2")) {
            System.out.println("Invalid input. Enter '1' to guess or '2' for hints:"); // prompt user for valid input
            choice = input.nextLine();
        }
        return choice; // return user's choice
    }
    
    public void addStrike() {
        strikes++; // increment strikes by 1
    }
    
    public int getStrikes() {
        return strikes; // return the number of strikes
    }
}