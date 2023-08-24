/* Casey Barajas
* MyScan
* 8/24/23
* Homework Assignment
*/

import java.util.Scanner;  // Importing the Scanner class

public class MyScan {

    public static void main(String[] args) {

        /* 1. Create a scanner */
        Scanner scan = new Scanner(System.in);
        
        /* 2. Welcome the user to your "bank" */
        System.out.println("Welcome to The Cheesy Bank!");
        System.out.println("Where your finances are as smooth as Brie and as strong as Cheddar!");
        System.out.println();

        /* 3. Collect information from a user that a bank would need. */

        // Collecting Name
        System.out.print("Please enter your full name: ");
        String fullName = scan.nextLine();
        System.out.println();

        // Collecting age
        System.out.print("Enter your age: ");
        int age = scan.nextInt();
        System.out.println();

        // Collecting cheese balance (in place of regular balance)
        System.out.print("How much cheese money do you currently have? (e.g., 12.50): ");
        double cheeseBalance = 0.0;

        try {
            cheeseBalance = scan.nextDouble();
        } catch(Exception e) {
            System.out.println("Oops! Please enter a valid number for your cheese balance.");
            return;  // Exit if invalid input
        }
        System.out.println();

        // Clearing the input buffer
        scan.nextLine();

        // Asking if user has a cheese card
        System.out.print("Do you own a premium cheese card? (true/false): ");
        boolean hasCheeseCard = scan.nextBoolean();
        System.out.println();

        // Clearing the words
        scan.nextLine();

        // Favorite Cheese Type
        System.out.print("What's your favorite type of cheese? (e.g., Cheddar, Brie, Mozzarella): ");
        String favoriteCheese = scan.next();
        System.out.println();

        // Asking for user's cheese statement (funny way to get a sentence input)
        System.out.print("Tell us why you love cheese in one sentence: ");
        String cheeseStatement = scan.nextLine();
        System.out.println();

        /* 4. Output a summary of their information and confirm that they want to join the bank. */

        System.out.println("Thank you for providing your details!");
        System.out.println("Here's a summary of your information:");
        System.out.println("---------------------------------------------------");
        System.out.println("Name: " + fullName);
        System.out.println("Age: " + age);
        System.out.println("Cheese Balance: $" + cheeseBalance);
        System.out.println("Owns a Premium Cheese Card: " + hasCheeseCard);
        System.out.println("Favorite Cheese: " + favoriteCheese);
        System.out.println("Your cheese statement: " + cheeseStatement);
        System.out.println("---------------------------------------------------");
        
        // Confirming the information
        System.out.print("Is the above information correct? (true/false): ");
        boolean isInfoCorrect = scan.nextBoolean();
        
        if(isInfoCorrect) {
            System.out.println("Great! Welcome to The Cheesy Bank!");
        } else {
            System.out.println("Oops! Please try again and ensure your details are accurate.");
        }

        // Closing the scanner
        scan.close();
    }
}
