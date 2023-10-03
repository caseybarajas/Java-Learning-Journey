/* Casey Barajas
* loops
* 8/25/23
* In-Class Notes
*/

import java.util.Scanner;

public class Loops
{
  public static void main(String[] args)
  {
    /* variables */
    Scanner scan = new Scanner(System.in);
    
    /* for Loops */
    for(int i = 5; i > 0; i--)
    {
      System.out.println(i);
    }
    
    System.out.println(); //spacing
    
    for(int i = -12; i <= -1; i /= 2)
    {
      System.out.println(i);
    }
    
    System.out.println(); //spacing

    String name = "samuel";
    
    for(int i = 0; i <= name.length(); i++)
    {
      System.out.println(name.substring(0, i));
    }
    
    System.out.println(); //spacing

    //sum from 0 to 21
    int sum = 0; //create the sum before adding to it
    
    for(int i = 0; i <= 21; i++)
    {
      sum += i; 
    }
    
    System.out.println("the sum is " + sum);
    
    System.out.println(); //spacing
    
    /* while loops */
    int balloons = 33; //number of balloons
    
    while(balloons <= 50)
    {
      System.out.println("i'm sad i only have " + balloons + " balloons");
      balloons++; //needs a "counter" so it will eventually terminate
      
    }
    
    System.out.println("yippee i have 50 balloons!!!");
    
    System.out.println(); //spacing

    //while loop with user input
    System.out.println("do you like balloons? (yes/no)");
    
    String input = scan.nextLine();
    
    while(input.equals("no"))
    {
      System.out.println("did your parents raise u right???");
      input = scan.nextLine();
    }
    
    System.out.println("u like balloons then!");
    
    System.out.println(); //spacing

    /* do-while loops (runs through at least once) */
    String num = "0";
    int counter = 1;
    
    System.out.println("first num: " + num);
    
    do
    {
      num += counter;
      counter++;
      
      System.out.println(num);
    }
    while(!num.equals("01234")); //runs until output is 01234
    
    System.out.println(); //spacing
    
    int watermelons = 30;
    int grapes = 20;
    
    do
    {
      grapes++; //bought one more grape
      
      System.out.println("i now have " + grapes + " grapes");
    }
    while(grapes <= watermelons);
    
    System.out.println(); //spacing
    
    /* checking for valid input */
    int age = -1; //invalid input
    do 
    {
      System.out.println("how old are you?");
      
      try
      {
        String userAge = scan.nextLine();
        
        age = Integer.parseInt(userAge);
      }
      catch(NumberFormatException e)
      {
        System.out.println("please enter valid data type >:(");
      }
    } while(age < 0);
    System.out.println("your age is " + age + " years old");
  }
}


