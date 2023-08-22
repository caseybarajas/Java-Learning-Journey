/* Casey Barajas
* MyNums
* 8/22/23
* Homework Assignment
*/

public class MyNums
{
  public static void main(String[] args)
  {
    // Exponent: 8x8x8x8
    double resultExpo = Math.pow(8, 4);
    System.out.println("8 raised to the 4th power is " + resultExpo);
    
    System.out.println(); //spacing
    
    // Square root of 92 truncated
    double sqrtVal = Math.sqrt(92);
    System.out.println("The truncated square root of 92 is " + (int)sqrtVal);
    
    System.out.println(); //spacing
    
    // Absolute value of -20.3
    double absVal = -20.3;
    System.out.println("The absolute value of " + absVal + " is " + Math.abs(absVal));
    
    System.out.println(); //spacing
    
    // Random number between 4 and 19
    int min = 4;
    int max = 19;
    double randomNum = Math.random() * (max - min) + min;
    System.out.println("Random number between 4 & 19: " + (int)randomNum);
    
    System.out.println(); //spacing
    
    // Square root of the absolute value of the difference between 12 squared and 5 squared
    double diff = Math.pow(12, 2) - Math.pow(5, 2);
    double result = Math.sqrt(Math.abs(diff));
    System.out.println("The square root of the absolute value of the difference between 12 squared and 5 squared is " + result);
    
    System.out.println(); //spacing
  }
}
