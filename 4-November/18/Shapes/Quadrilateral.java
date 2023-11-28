/*
* Casey Barajas
* 10/17/23
* Quadrilateral (child to Shape)
* Shapes Homework
*/
import java.util.Scanner;

public class Quadrilateral extends Shape {
    private double width;
    private double length;

    public Quadrilateral() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter width of quadrilateral: ");
        width = scanner.nextDouble();
        System.out.print("Enter length of quadrilateral: ");
        length = scanner.nextDouble();
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    @Override
    public double calculateArea(double width, double length) {
        return super.calculateArea(width, length);
    }

    @Override
    public double calculatePerimeter(double width, double length) {
        return super.calculatePerimeter(width, length);
    }
}
