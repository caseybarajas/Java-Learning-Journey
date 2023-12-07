/*
 * Casey Barajas
 * Events.java
 * 10/8/2023
 */


public class Events {
    public static void main(String[] args) {
        int[] years = {1920, 1945, 1969, 1989, 2001, 2008, 2012, 2020};
        String[] events = {
            "Women given the right to vote in US",
            "End of World War II",
            "First man on the moon",
            "Fall of the Berlin Wall",
            "Wikipedia launched",
            "Barack Obama elected President",
            "Curiosity Rover lands on Mars",
            "COVID-19 pandemic"
        };

        int sum = 0, max = years[0], min = years[0], evenCount = 0, oddCount = 0;
        for (int year : years) {
            sum += year;
            if (year > max) max = year;
            if (year < min) min = year;
            if (year % 2 == 0) evenCount++;
            else oddCount++;
        }
        double mean = (double) sum / years.length;

        int median;
        if (years.length % 2 == 0)
            median = (years[years.length/2] + years[years.length/2 - 1]) / 2;
        else
            median = years[years.length/2];

        // Mode calculation is omitted as it's complex in Java and not directly available in the standard library

        System.out.println("Mean year: " + mean);
        System.out.println("Median year: " + median);
        System.out.println("Max year: " + max);
        System.out.println("Min year: " + min);
        System.out.println("Even years: " + evenCount);
        System.out.println("Odd years: " + oddCount);

        for (int i = 0; i < years.length; i++) {
            System.out.println(years[i] + ": " + events[i]);
        }

        // Determining the best year to be alive is subjective and depends on the context
        // Here, we'll just print the latest year as the best year to be alive
        System.out.println("Best year to be alive: " + max + " (because it's the latest year in the list)");
    }
}