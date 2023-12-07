/*
 * Casey Barajas
 * Thanksgiving.java
 * 12/8/2023
 */

public class Thanksgiving {
    public static void main(String[] args) {
        String[] students = {"Adrian", "Aidan", "Casey", "Hollywood", "Jack", "Jade", "James", "Sam", "Tyler"};
        String[] food = new String[students.length];

        // Simulate asking each student what they're going to bring
        // In a real application, this would involve user input
        food[0] = "turkey";
        food[1] = "cranberry";
        food[2] = "potatoes";
        food[3] = "juice";
        food[4] = "stuffing";
        food[5] = "ham";
        food[6] = "dinner rolls";
        food[7] = "hot sauce";
        food[8] = "pie";

        for (int i = 0; i < students.length; i++) {
            System.out.println("For Thanksgiving, we will have " + food[i] + " from " + students[i]);
        }
    }
}
