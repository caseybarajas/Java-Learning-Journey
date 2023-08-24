/* Casey Barajas
* scanner
* 8/24/23
* In-Class Notes
*/
import java.util.Scanner; //import because not inherit to java


public class ScannerNotes
{
  public static void main(String[] args)
  {
    /* scanner allows you to take input from the user */
    
    //create the scanner (named scan)
    Scanner scan = new Scanner(System.in);
    
    //ask a question 
    System.out.println("do you like cheese? (yes/no)");
    
    //retrive the answer from the user | .next() only takes the first word
    String cheese = scan.next();
    
    //use the variable
    System.out.println("cheese? " + cheese);
    
    System.out.println(); //spacing
    
    //consume the extra words
    scan.nextLine();
    
    //new prompt 
    System.out.println("what is your favorite cheese?");
    
    //get the full line of input
    String faveCheese = scan.nextLine();
    
    System.out.println("ur fav cheese is " + faveCheese);
    
    System.out.println(); //spacing
    
    //new question
    System.out.print("how many cheese wheels did you sell?");
    
    //get answer
    int cheeseWheels = scan.nextInt();
    
    System.out.println("you sold " + cheeseWheels + " wheels of cheese!");
    
    System.out.println(); //spacing
    
    //new questions
    System.out.println("did you have cheese this morning? (true/false)");
    
    //collect a boolean
    boolean hadCheese = scan.nextBoolean();
    
    System.out.println("it is " + hadCheese + " that u had cheese today");
    
    System.out.println(); //spacing
    
    /* data insurance: did thye give you the right data type */
    System.out.println("how much cheese money do you have?");
    
    double cheeseMoney = 0;
    
    //try-catch | works with any data type - don't need for Strings
    try
    {
      String cheeseMon = scan.next();
      
      cheeseMoney = Double.parseDouble(cheeseMon); //convert the String to a double
    }
    catch(NumberFormatException e)
    {
      // Optional error print line | System.out.println("error: " + e);
      System.out.println("are you absoultly stupid?? give me a number next time");
    }
    
    System.out.println("you have $" + cheeseMoney + " to spend on cheese");
    
  }
}