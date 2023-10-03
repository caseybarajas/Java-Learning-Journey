/* Casey Barajas
* Basics.java
* 8/21/23
* In Class Notes
*/

public class Basics  //class names start with a capital letter
{
  public static void main(String[] args)  //main method (makes things happen)
  {
    System.out.println("hello world");  //ln creates new line after the output
    
    System.out.print("chair");  //example of no new line
    
    System.out.println("cheese");
    
    System.out.println(); //spacing
    
    /* variables //type name = value */
    
    int bestMovieYear = 1996; 
    
    double money = 0.37; // double is a decimal number +/-
    
    boolean homework = true; // boolean is T/F
    
    String name = "casey"; //String is words //String needs capital S
    
    /* print some stuff */
    
    System.out.println("the best year for movies is " + bestMovieYear);
    
    bestMovieYear = 1999; //changing variables
    
    System.out.println("the new best year for movies is " + bestMovieYear);
    
    System.out.println(); //spacing
    
    /* String concatentation (con-cat-in-nation) */ //put together two strings
    System.out.println(name + " has homework: " + homework + " and $" + money);
  }
}