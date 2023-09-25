/* Casey Barajas
 * Subway.java
 * 5/25/23
 * Homework
 */

public class Item {
    protected String name;
    protected double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return name + " - $" + price;
    }
}
