/*
 * Cell.java
 * Casey Barajas
 * 3/6/2024
 * 
 * This file contains the Cell class for the Lexilogic game. The Cell class is responsible for keeping track of the
 * word, hint, and position of each cell in the grid.
 * 
 * cells are like the cells in our body. They are the building blocks of life. They are the building blocks of the
 * Lexilogic game. They are the building blocks of the Lexilogic game. They are the building blocks of the Lexilogic
 * game. They are the building blocks of the Lexilogic game. They are the building blocks of the Lexilogic game. They
 * are the building blocks of the Lexilogic game. They are the building blocks of the Lexilogic game. They are the
 * building blocks of the Lexilogic game. They are the building blocks of the Lexilogic game. They are the building
 * 
 * i think im going insane, JK GUYS ALL JUST A THEORY 
 * A GAME THEORY
 * 
 */

public class Cell {
    private String word; // the word in the cell
    private String hint; // a hint for the word
    private String placement; // the position of the cell
    private boolean solved; // indicates if the cell is solved or not

    public Cell(String word, String hint, String placement) {
        this.word = word;
        this.hint = hint;
        this.placement = placement; 
        solved = false;
    }
    
    public String showWord() {
        return word; // returns the word in the cell
    }
    
    public String showHint() {
        return hint; // returns the hint for the word
    }
    
    public String showPlacement() {
        return placement; // returns the position of the cell
    }
    
    public void markSolved() {
        solved = true; // marks the cell as solved
    }
    
    public boolean isSolved() {
        return solved; // returns true if the cell is solved, false otherwise
    }
}