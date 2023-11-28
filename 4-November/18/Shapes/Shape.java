/*
* Casey Barajas
* 10/17/23
* Shape class
* Shapes Homework
*/
public class Shape {
    public Shape() {
        System.out.println("you have a new shape!");
    }

    public double calculateArea(double width, double length) {
        return width * length;
    }

    public double calculatePerimeter(double width, double length) {
        return 2 * width + 2 * length;
    }
}
