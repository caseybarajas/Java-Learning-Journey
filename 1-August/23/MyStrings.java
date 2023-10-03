/* Casey Barajas
* MyStrings
* 8/23
* Homework Assignment
*
* the blocks are the step by step so i can keep myself on track
*/

public class MyStrings
{
  public static void main(String[] args)
  {
    /* 1. Create a string for your first name (whole thing) */
    String firstName = "Casey";
    
    System.out.println(); //spacing

    /* 2. Use the substring methods to create a String that holds your nickname */
    String nickName = firstName + "pie"; // This adds "pie" to "Casey" to get "Caseypie"


    /* 3. Print your first name, then using the escape sequences, create a new line, and print your nickname in quotes */
    System.out.println(firstName + "\n\"" + nickName + "\"");

    System.out.println(); //spacing
    
    /* 4. Locate and print the first occurrence of a vowel in your name */
    int firstVowelIndex = firstName.indexOf('a'); // The first vowel in "Casey" is 'a'
    System.out.println("The first vowel in " + firstName + " is at index " + firstVowelIndex);
    
    System.out.println(); //spacing
    
    /* 5. Print whether your full name and nickname match */
    boolean isSame = firstName.equals(nickName);
    System.out.println("My full name and nickname match: " + isSame);
    
    System.out.println(); //spacing
    
    /* 6. Add your middle and last name to your first using the methods of String concatenation and print */
    String middleName = "Conner";
    String lastName = "Barajas";
    String fullName = firstName + " " + middleName + " " + lastName; // Using + for concatenation
    System.out.println("My full name is: " + fullName);
    
    System.out.println(); //spacing
  }
}
