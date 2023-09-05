/* Casey Barajas
* Zodiac.java
* 9/5/23
* Program to determine Zodiac sign
*/
import java.util.Scanner;

public class Zodiac
{
  public static void main(String[] args)
  {
    // Initialize scanner
    Scanner scan = new Scanner(System.in);

    // Main program loop
    while(true)
    {
      // Collect name and birthday
      System.out.println("Enter your name:");
      String name = scan.nextLine();
      
      System.out.println("Enter your birth date as MM.DD (e.g., 11.29 for November 29):");
      double birthDate = scan.nextDouble();
      scan.nextLine(); // Consume the newline

      System.out.println(); //spacing
      
      // Determine Zodiac sign
      String zodiacSign = "";

      if(birthDate >= 1.20 && birthDate <= 2.18)
      {
        zodiacSign = "Aquarius";
      }
      else if(birthDate >= 2.19 && birthDate <= 3.20)
      {
        zodiacSign = "Pisces";
      }
      else if(birthDate >= 3.21 && birthDate <= 4.19)
      {
        zodiacSign = "Aries";
      }
      else if(birthDate >= 4.20 && birthDate <= 5.20)
      {
        zodiacSign = "Taurus";
      }
      else if(birthDate >= 5.21 && birthDate <= 6.20)
      {
        zodiacSign = "Gemini";
      }
      else if(birthDate >= 6.21 && birthDate <= 7.22)
      {
        zodiacSign = "Cancer";
      }
      else if(birthDate >= 7.23 && birthDate <= 8.22)
      {
        zodiacSign = "Leo";
      }
      else if(birthDate >= 8.23 && birthDate <= 9.22)
      {
        zodiacSign = "Virgo";
      }
      else if(birthDate >= 9.23 && birthDate <= 10.22)
      {
        zodiacSign = "Libra";
      }
      else if(birthDate >= 10.23 && birthDate <= 11.21)
      {
        zodiacSign = "Scorpio";
      }
      else if(birthDate >= 11.22 && birthDate <= 12.21)
      {
        zodiacSign = "Sagittarius";
      }
      else if((birthDate >= 12.22 && birthDate <= 12.31) || (birthDate >= 1.01 && birthDate <= 1.19))
      {
        zodiacSign = "Capricorn";
      }
      else
      {
        zodiacSign = "Invalid date";
      }
      
      // Display the result
      System.out.println(name + ", your sun sign is: " + zodiacSign);
      
      System.out.println(); //spacing

      // Ask if the user wants to continue
      System.out.println("Would you like to find another Zodiac sign? (yes/no):");
      String continueChoice = scan.nextLine();

      if(!continueChoice.equalsIgnoreCase("yes"))
      {
        break;
      }

      System.out.println(); //spacing
    }
  }
}
