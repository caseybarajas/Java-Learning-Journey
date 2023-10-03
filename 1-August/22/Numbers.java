/* Casey Barajas
* Numbers
* 8/22/23
* In-Class Notes
*/

public class Numbers
{
  public static void main(String[] args)
  {
    int myMonth = 2; 
    int myDay = 29; 
    int myYear = 2005; 
    int myHour = 11; 
    int myMin = 37; 
    
    System.out.println("2 times 11 is " + 2*myHour); //can do math inside output statment
    
    int totalNum = myMonth + myDay + myYear + myHour + myMin;
    System.out.println("the total of all numbers is " + totalNum);
    System.out.println("the average of our numbers is " + totalNum/5);
    
    /* modulo > the remainder of dividing */
    
    int remainder = myYear % myDay;
    System.out.println("myYear % myDay is " + remainder);
    
    System.out.println(); //spacing
    
    /* Increments % decrements */
    
    int myAge = 16; 
    System.out.println("my age is " + myAge);
    
    myAge++; //increasing myAge by 1 (++ is increase by 1)
    System.out.println("on my birthday, i will turn " + myAge);
    
    myDay--; //decrement myDay by 1 (-- will decrease by 1)
    System.out.println("the day before my birthday is " + myDay);
    
    System.out.println(); //spacing
    
    /* compound operators */ //reasigns and recalculates in one
    
    double myWallet = 50.04; //money i have
    myWallet *= 2; //multiply wallet by 2 and reassigning it 
    System.out.println("i now have $" + myWallet + " after the bet");
    
    System.out.println(); //spacing
    
    /* math class methods */
    
    //random number [0, 1)
    double rando = Math.random();
    System.out.println(rando);
    
    //random number [min, max)
    int min = 4;  //minimum
    int max = 10; //maximum
    
    double randoTwo = Math.random() * (max - min) + min;
    System.out.println("random number between 4 & 10: " + randoTwo);
    
    //printing rounding
    System.out.printf("the rounded random number is %.2f", randoTwo); //%.#f > # tells how many decimal points
    
    System.out.println(); //spacing
    System.out.println(); //spacing
    
    //absolute value //Math.abs(  )
    double absVal = -9.2;
    System.out.println("the absolute value of " + absVal + " is " + Math.abs(absVal));
    
    System.out.println(); //spacing
    
    //exponents
    int base = 4;
    int expo = 3;
    
    System.out.println(); //spacing
    
    //raise 4 to the 3rd power
    double raisePower = Math.pow(base, expo);
    System.out.println("4 to the 3rd power is " + raisePower);
    
    //square root
    double sqRoot = Math.sqrt(25);
    System.out.printf("the square root of 25 is %.0f", sqRoot);
    
    System.out.println(); //spacing
    System.out.println(); //spacing
    
    // casting
    int hands = 7;
    double distance = 30.7;
    
    //prints as double (keeps decimal)
    System.out.println("adding int + double = " + (hands + distance));
 
    //prints as an int (truncates/removes the decimal) //use printf to round
    System.out.println("adding int + double = " + (int) + (hands + distance));
    
  }
}