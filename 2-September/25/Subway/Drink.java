/* Casey Barajas
 * Subway.java
 * 5/25/23
 * Homework
 */

import java.util.Scanner;

public class Drink extends Item {
    private String size;
    private String type;

    public Drink(String size, String type) {
        super("Drink", 1.99); // Set the base price for a drink
        this.size = size;
        this.type = type;
    }

    @Override
    public String toString() {
        return size + " " + name + " (" + type + ") - $" + price;
    }

    public static Drink createDrink() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter drink size: ");
        String size = scanner.next();
        System.out.print("Enter drink type: ");
        String type = scanner.next();
        return new Drink(size, type);
    }
}

