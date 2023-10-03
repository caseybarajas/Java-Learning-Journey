/*
 * Casey Barajas
 * 10/03/23
 * Arcade Game
 * MathGame.java
 * A game where the computer generates a random target number and operation.
 * The user must then input two numbers which, when the operation is applied,
 * equal the target number. The user's and computer's scores are updated 
 * based on the correctness of the user’s answer.
 */

import java.util.Random;
import java.util.Scanner;

public class MathGame {
    private User user;
    private int targetNumber;
    private char operation;

    public MathGame(User user) {
        Random rand = new Random();
        this.user = user;
        this.targetNumber = rand.nextInt(30) + 1;

        char[] operations = {'+', '-', '*', '/', '%'};
        this.operation = operations[rand.nextInt(operations.length)];
    }

    private boolean checkAnswer(int num1, int num2) {
        switch(operation) {
            case '+': return num1 + num2 == targetNumber;
            case '-': return num1 - num2 == targetNumber;
            case '*': return num1 * num2 == targetNumber;
            case '/': return num1 / num2 == targetNumber;
            case '%': return num1 % num2 == targetNumber;
            default: return false;
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        int num1, num2;

        System.out.println("Find two numbers that, when operated by " + operation + ", equals: " + targetNumber);
        while(true) {
            try {
                System.out.println("Enter first number: ");
                num1 = Integer.parseInt(scanner.nextLine());

                System.out.println("Enter second number: ");
                num2 = Integer.parseInt(scanner.nextLine());

                if(checkAnswer(num1, num2)) {
                    System.out.println("Correct! " + num1 + " " + operation + " " + num2 + " equals " + targetNumber);
                    user.incrementUserScore();
                } else {
                    System.out.println("Incorrect. Try again.");
                    user.incrementComputerScore();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}

