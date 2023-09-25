/* Casey Barajas
 * Subway.java
 * 5/25/23
 * Homework
 */

import java.util.Scanner;

public class Subway {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MAX_ITEMS = 100; // Maximum number of items in the order
        Item[] order = new Item[MAX_ITEMS];
        int itemCount = 0;
        double totalCost = 0;

        // Ask the user if they want to add items to their order
        while (true) {
            System.out.println("Welcome to Subway!");
            System.out.println("1. Add a sandwich");
            System.out.println("2. Add a drink");
            System.out.println("3. Finish order");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                order[itemCount++] = Sandwich.createSandwich();
            } else if (choice == 2) {
                order[itemCount++] = Drink.createDrink();
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        // Calculate the total cost and print the receipt
        System.out.println("\nReceipt:");
        for (int i = 0; i < itemCount; i++) {
            System.out.println(order[i].toString());
            totalCost += order[i].getPrice();
        }
        System.out.println("\nTotal Cost: $" + totalCost);
    }
}
