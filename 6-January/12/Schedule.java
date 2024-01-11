/*
 * Casey Barajas
 * Schedule.java
 * 01/12/2024
 */

import java.util.ArrayList;

public class Schedule {
    public static void main(String[] args) {
        // 1. Create Strings to represent the classes that you are currently enrolled in
        String class1 = "Algebra 2 Math";
        String class2 = "English Literature";
        String class3 = "Physics";
        String class4 = "History";
        String class5 = "Computer Science";
        String class6 = "Physical Education";

        System.out.println(); //spacing

        // 2. Create an ArrayList of those Strings
        ArrayList<String> schedule = new ArrayList<>();
        schedule.add(class1); // a. Enter them in the order you have the classes
        schedule.add(class2);
        schedule.add(class3);
        schedule.add(class4);
        schedule.add(class5);
        schedule.add(class6);

        System.out.println(); //spacing

        // 3. Print the ArrayList and its size
        System.out.println("Full Schedule: " + schedule);
        System.out.println("Number of Classes: " + schedule.size());

        System.out.println(); //spacing

        // 4. Traverse the array to individually print each class you are in
        for (String aClass : schedule) {
            System.out.println(aClass);
        }

        System.out.println(); //spacing

        // 5. Use a for loop to print what math class you are in and during what period
        for (int i = 0; i < schedule.size(); i++) {
            if (schedule.get(i).contains("Math")) {
                System.out.println("Math class (" + schedule.get(i) + ") is in period " + (i + 1));
            }
        }

        System.out.println(); //spacing

        // 6. Use a while loop and ifs to remove your 2 least favorite classes from the list
        String leastFavorite1 = "History";
        String leastFavorite2 = "Physical Education";
        int i = 0;
        while (i < schedule.size()) {
            if (schedule.get(i).equals(leastFavorite1) || schedule.get(i).equals(leastFavorite2)) {
                System.out.println("I don't like class " + schedule.get(i)); // a. output: i dont like class ____
                schedule.remove(i);
            } else {
                i++;
            }
        }

        System.out.println(); //spacing

        // 7. Print the new schedule
        System.out.println("New Schedule: " + schedule);

        System.out.println(); //spacing

        // 8. Print each class name shortened to the first three letters
        for (String aClass : schedule) {
            System.out.println(aClass.substring(0, 3));
        }

        System.out.println(); //spacing

        // 9. Print the new ArrayList
        System.out.println("Final Schedule: " + schedule);
    }
}