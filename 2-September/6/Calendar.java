/*
* Casey Barajas
* 9/6/23
* Porjcet thing
*/

import java.util.Scanner;

public class Calendar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Ask the user for a month
        System.out.println("Enter the month (either as a string or an integer):");
        String input = scanner.next();

        int days = 0;
        String month = "";

        // Step 2: Use switch-case to determine the number of days in the month
        switch (input.toLowerCase()) {
            case "january":
            case "1":
                days = 31;
                month = "January";
                break;
            case "february":
            case "2":
                month = "February";
                // Step 3a: Ask for the year if February is chosen
                System.out.println("Enter the year:");
                int year = scanner.nextInt();
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    // Step 3b: It is a leap year
                    days = 29;
                } else {
                    days = 28;
                }
                break;
            case "march":
            case "3":
                days = 31;
                month = "March";
                break;
            case "april":
            case "4":
                days = 30;
                month = "April";
                break;
            case "may":
            case "5":
                days = 31;
                month = "May";
                break;
            case "june":
            case "6":
                days = 30;
                month = "June";
                break;
            case "july":
            case "7":
                days = 31;
                month = "July";
                break;
            case "august":
            case "8":
                days = 31;
                month = "August";
                break;
            case "september":
            case "9":
                days = 30;
                month = "September";
                break;
            case "october":
            case "10":
                days = 31;
                month = "October";
                break;
            case "november":
            case "11":
                days = 30;
                month = "November";
                break;
            case "december":
            case "12":
                days = 31;
                month = "December";
                break;
            default:
                // Step 4: Have a default case
                System.out.println("Invalid month entered.");
                return;
        }

        // Display the number of days in the chosen month
        System.out.println("The month of " + month + " has " + days + " days.");
    }
}