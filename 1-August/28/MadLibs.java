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
        String name, typeOfCheese, clownName, adjective, place, action, animal, hobby;
        
        /* Data Collection */
        // 1. Name
        System.out.println("Hey, what's your name?");
        name = scan.nextLine();
        
        // 2. Number of Cheeses with Data Insurance
        do {
            System.out.println("How many types of cheese do you own?");
            try {
                numberOfCheeses = Integer.parseInt(scan.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Give me a number, cheese lover!");
            }
        } while (true);

        // 3. Favorite Type of Cheese
        System.out.println("What's your favorite type of cheese?");
        typeOfCheese = scan.nextLine();
        
        // 4. Clown Name
        System.out.println("What's the name of the clown in your story?");
        clownName = scan.nextLine();
        
        // 5. Adjective
        System.out.println("Give me an adjective:");
        adjective = scan.nextLine();

        // 6. Place
        System.out.println("Name a place:");
        place = scan.nextLine();

        // 7. Action
        System.out.println("Name an action:");
        action = scan.nextLine();

        // 8. Animal
        System.out.println("Name an animal:");
        animal = scan.nextLine();

        // 9. Hobby
        System.out.println("Name a hobby:");
        hobby = scan.nextLine();
        
        // 10. Clown Shoe Size with Data Insurance
        do {
            System.out.println("What's the clown's shoe size?");
            try {
                clownShoeSize = Double.parseDouble(scan.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong size! Clowns need numbers, not gibberish!");
            }
        } while (true);

        // 11. Fear of Clowns
        System.out.println("Are you scared of clowns? (true/false)");
        isScaredOfClowns = Boolean.parseBoolean(scan.nextLine());

        /* Story Time */
        // Outputting the Mad Lib story
        System.out.println("\nAlright, here's your Mad Lib story:");
        System.out.println(name + " was a connoisseur of cheese, owning exactly " + numberOfCheeses + " types.");
        System.out.println("One day in " + place + ", while enjoying some " + typeOfCheese + ", a clown named " + clownName + " with a shoe size of " + clownShoeSize + " burst into the room.");
        System.out.println("The " + adjective + " clown handed " + name + " a " + animal + " shaped balloon and said, 'I have a message for you.'");
        System.out.println("Feeling " + (isScaredOfClowns ? "terrified" : "intrigued") + ", " + name + " decided to " + action + " the balloon.");
        System.out.println("Inside the balloon was another piece of " + typeOfCheese + " and a note about " + hobby + "!");
        System.out.println("'This is a cheesy miracle!' exclaimed " + name + ".");
        System.out.println("The clown's oversized shoes suddenly deflated, shrinking down to " + clownShoeSize + ".");
        System.out.println("It turns out the clown was a cheese genie, capable of granting " + numberOfCheeses + " cheese-related wishes.");
        System.out.println("So, " + name + " wished for a lifetime supply of " + typeOfCheese + ", a cheese moon, and for all clowns to never be scary again.");
        System.out.println("And they all lived cheesily ever after in " + place + ".");
    }
}
