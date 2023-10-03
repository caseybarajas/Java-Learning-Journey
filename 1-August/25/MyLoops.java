/* Casey Barajas
* MyLoops
* 8/25/23
* Homework Assignment
*/

import java.util.Scanner;

public class MyLoops
{
  public static void main(String[] args)
  {
    /* Initialize scanner */
    Scanner scan = new Scanner(System.in);

    /* 1. Print the difference of all numbers [-10, 30) */
    System.out.println("1. Printing the difference of numbers from -10 to 30:");

    int difference = 0;
    for(int i = -10; i < 30; i++)
    {
      difference -= i;
    }
    System.out.println("The difference of all numbers from -10 to 30 is: " + difference);
    
    System.out.println(); //spacing

    /* 2. Fibonacci Sequence */
    System.out.println("2. Fibonacci Sequence:");

    int first = 0, second = 1, terms = 0;

    // a. ask the user for 3 inputs: the first, the second and how many terms they want total (data insurance)
    do 
    {
      System.out.println("Enter the first number:");
      try
      {
        first = Integer.parseInt(scan.nextLine());
      }
      catch(NumberFormatException e)
      {
        System.out.println("Invalid input, please enter a valid number.");
      }
    } while(first < 0);
    
    do 
    {
      System.out.println("Enter the second number:");
      try
      {
        second = Integer.parseInt(scan.nextLine());
      }
      catch(NumberFormatException e)
      {
        System.out.println("Invalid input, please enter a valid number.");
      }
    } while(second < 0);
    
    do 
    {
      System.out.println("How many terms do you want?");
      try
      {
        terms = Integer.parseInt(scan.nextLine());
      }
      catch(NumberFormatException e)
      {
        System.out.println("Invalid input, please enter a valid number.");
      }
    } while(terms <= 0);
    
    // b. print the completed pattern in one line
    System.out.print("Fibonacci Sequence: " + first + " " + second + " ");
    int count = 2; // As we've already printed two terms
    while(count < terms)
    {
      int nextTerm = first + second;
      System.out.print(nextTerm + " ");
      first = second;
      second = nextTerm;
      count++;
    }
    System.out.println(); //spacing

    /* 3. Use string concatenation to print this pattern */
    System.out.println("3. Printing pattern:");
    String pattern = "";
    for(int i = 0; i < 5; i++)
    {
      pattern += "*";
      System.out.println(pattern);
    }
    
    // Closing scanner
    scan.close();
  }
}
