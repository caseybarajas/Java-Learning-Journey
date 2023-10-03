/* Casey Barajas
 * Subway.java
 * 5/25/23
 * Homework
 */

import java.util.Scanner;

public class Sandwich extends Item {
    private String size;
    private String toppings;

    public Sandwich(String size, String toppings) {
        super("Sandwich", 5.99); // Set the base price for a sandwich
        this.size = size;
        this.toppings = toppings;
    }

    @Override
    public String toString() {
        return size + " " + name + " with " + toppings + " - $" + price;
    }

    public static Sandwich createSandwich() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter sandwich size: ");
        String size = scanner.next();
        System.out.print("Enter toppings (comma-separated): ");
        scanner.nextLine(); // Consume the newline
        String toppings = scanner.nextLine();
        return new Sandwich(size, toppings);
    }
}
