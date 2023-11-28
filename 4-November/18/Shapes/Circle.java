/*
* Casey Barajas
* 10/17/23
* Circle (child to Shape)
* Shapes Homework
*/
import java.util.Scanner;

public class Circle extends Shape {
    private double radius;

    public Circle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter radius of circle: ");
        radius = scanner.nextDouble();
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double calculateArea(double width, double length) {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double calculatePerimeter(double width, double length) {
        return 2 * Math.PI * radius;
    }
}
