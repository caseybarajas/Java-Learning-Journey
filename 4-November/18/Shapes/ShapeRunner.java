/*
* Casey Barajas
* 10/17/23
* ShapeRunner class
* Shapes Homework
*/
import java.util.Scanner;

public class ShapeRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.print("What shape do you have (quad or circle)? ");
            choice = scanner.nextLine().toLowerCase();

            switch (choice) {
                case "quad":
                    Quadrilateral quad = new Quadrilateral();
                    System.out.println("Area: " + quad.calculateArea(quad.getWidth(), quad.getLength()));
                    System.out.println("Perimeter: " + quad.calculatePerimeter(quad.getWidth(), quad.getLength()));
                    break;
                case "circle":
                    Circle circle = new Circle();
                    System.out.println("Area: " + circle.calculateArea(circle.getRadius(), circle.getRadius()));
                    System.out.println("Perimeter: " + circle.calculatePerimeter(circle.getRadius(), circle.getRadius()));
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            System.out.print("Do you have another shape (yes/no)? ");
            choice = scanner.nextLine().toLowerCase();

        } while (!choice.equals("no"));
    }
}
