/*
 * Casey Barajas
 * 10/03/23
 * Arcade Game
 * User.java
 * Class to manage and store user-related data such as name, score, and 
 * the computer's score. Provides methods to increment scores and 
 * retrieve user information.
 */

public class User {
    private String name;
    private int userScore;
    private int computerScore;

    public User(String name) {
        this.name = name;
        this.userScore = 0;
        this.computerScore = 0;
    }

    public String getName() {
        return name;
    }

    public int getUserScore() {
        return userScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public void incrementUserScore() {
        this.userScore++;
    }

    public void incrementComputerScore() {
        this.computerScore++;
    }

    @Override
    public String toString() {
        return "User: " + name + "\nUser Score: " + userScore + "\nComputer Score: " + computerScore;
    }
}
