/* Casey Barajas
* MadLibs
* 8/28/23
* Project
*/

import java.util.Scanner;


public class MadLibs {
    
    public static void main(String[] args) {
        // Initialize the Scanner
        Scanner scan = new Scanner(System.in);

        /* Introduction */
        // Welcome the player
        System.out.println("Welcome to the Cheesy, Clownish, and Balloontastic Mad Libs Game!");
        
        /* Variables */
        int numberOfCheeses;
        double clownShoeSize;
        boolean isScaredOfClowns;
        String name;
        String typeOfCheese;

        /* Data Collection */
        // Name
        System.out.println("Hey, what's your name?");
        name = scan.nextLine();
        
        // Number of Cheeses with Data Insurance
        do {
            System.out.println("How many types of cheese do you own?");
            try {
                numberOfCheeses = Integer.parseInt(scan.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Give me a number, cheese lover!");
            }
        } while (true);

        // Favorite Type of Cheese
        System.out.println("What's your favorite type of cheese?");
        typeOfCheese = scan.nextLine();
        
        // Clown Shoe Size with Data Insurance
        do {
            System.out.println("What's your clown shoe size?");
            try {
                clownShoeSize = Double.parseDouble(scan.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong size! Clowns need numbers, not gibberish!");
            }
        } while (true);

        // Fear of Clowns
        System.out.println("Are you scared of clowns? (true/false)");
        isScaredOfClowns = Boolean.parseBoolean(scan.nextLine());

        /* Story Time */
        // Let's see what we've got
        System.out.println("\nAlright, here's your Mad Lib story:");
        System.out.println(name + " was a connoisseur of cheese, owning exactly " + numberOfCheeses + " types.");
        System.out.println("One day, while enjoying some " + typeOfCheese + ", a clown with a shoe size of " + clownShoeSize + " burst into the room.");
        System.out.println("The clown handed " + name + " a balloon and said, 'I have a message for you.'");
        System.out.println("Feeling " + (isScaredOfClowns ? "terrified" : "intrigued") + ", " + name + " popped the balloon.");
        System.out.println("Inside the balloon was another piece of " + typeOfCheese + "!");
        System.out.println("'This is a cheesy miracle!' exclaimed " + name + ".");
        System.out.println("The clown's oversized shoes suddenly deflated, shrinking down to regular size.");
        System.out.println("It turns out the clown was a cheese genie, capable of granting " + numberOfCheeses + " cheese-related wishes.");
        System.out.println("So, " + name + " wished for a lifetime supply of " + typeOfCheese + ", a cheese moon, and for all clowns to never be scary again.");
        System.out.println("And they all lived cheesily ever after.");
    }
}
