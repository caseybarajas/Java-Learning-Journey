/*
 * Casey Barajas
 * The Game of Nim Project
 * Board class
 * 9/27/23
 * 
 * This class represents the game board of Nim. It keeps track of 
 * the number of pieces left and provides a method to populate 
 * the board with a random number of pieces at the start of each game.
 */


public class Board
{
  public static int pieces; //amount of pieces on the board
  
  //create the board
  public static void populate()
  {
    pieces = (int) (Math.random()*(50 - 10) + 10); //sets pieces equal to random number between 10 and 50
  }
  
  //how many pieces are currently on the board?
  public static int getPieces()
  {
    return pieces;
  }
}