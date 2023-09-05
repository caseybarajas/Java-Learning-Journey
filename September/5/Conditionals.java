/* Casey Barajas
* conditionals
* 9/5/23
* notes
*/
import java.util.Scanner;

public class Conditionals
{
  public static void main(String[] args)
  {
    //conditionals check to see if a statment is true
    
    Scanner scan = new Scanner(System.in);
    
    /* number conditionals */
    System.out.println("how many hours did you work this weekend?");
    int hours = scan.nextInt();
    
    if(hours < 10)
    {
      System.out.println("short work day");
    }
    else
    {
      System.out.println("light work, no reaction");
    }
    
    System.out.println(); //spacing
    
    /* if/ else/if */
    System.out.println("how much money did you make?");
    double money = scan.nextDouble();
    
    if(money <= 200)
    {
      System.out.println("work harder dude bro");
    }
    else if(money > 500)
    {
      System.out.println("u made bank dude bro");
    }
    else
    {
      System.out.println("u made an average amount of money");
    }
    
    System.out.println(); //spacing

    /* multiple conditions */
    System.out.println("give me an int");
    int userOne = scan.nextInt();
    
    System.out.println("give me an int");
    int userTwo = scan.nextInt();
    
    System.out.println("give me an int");
    int userThree = scan.nextInt();
    
    if((userOne > userTwo) && (userOne > userThree))
    {
      System.out.println("the first number was the biggest");
    }
    else if ((userTwo > userOne) && (userTwo > userThree))
    {
      System.out.println("second number was the biggest");
    }
    else if ((userThree > userOne) && (userThree > userTwo))
    {
      System.out.println("third number was the biggest");
    }
    else
    {
      System.out.println("some of ur numbers are the same");
    }
    
    // || means only one thing must be true
    if((userOne == userTwo) || (userOne == userThree))
    {
      System.out.println("the first value was used twice");
    }
    else if((userTwo == userOne) || (userTwo == userThree))
    {
      System.out.println("the second value was used twice");
    }
    else if((userThree == userOne) || (userThree == userTwo))
    {
      System.out.println("the third value was used twice");
    }
    else if((userThree == userOne) || (userThree == userTwo) && (userTwo == userOne)) // won't get here b/c first if is true
    {
      System.out.println("all your values are the same");
    }
    else
    {
      System.out.println("all numbers were used once");
    }
    
    System.out.println(); //spacing
    scan.nextLine(); //next input line
    
    /* String conditions */
    System.out.println("what is your first name?");
    String name = scan.nextLine();
    
    if(name.length() > 4)
    {
      System.out.println("your name is too long.");
      System.out.println("your new nickname is " + name.substring(0, 3));
    }
    else
    {
      System.out.println("your nickname is just your name");
    }
    
    System.out.println(); //spacing
    
    System.out.println("what does ur mom call u?");
    String nickname = scan.nextLine();
    
    if(name.equalsIgnoreCase(nickname))
    {
      System.out.println("ur name is the same as what ur mom calls u");
    }
    else 
    {
      System.out.println("ur mom has a nickname for u");
    }
    
    System.out.println(); //spacing
    
    System.out.println("what is ur favorite letter?");
    String letter = scan.nextLine();

    if(name.contains(letter))
    {
      System.out.println("ur fav letter is at " + name.indexOf(letter));
    }
    else
    {
      System.out.println("ur name does not have ur fav letter");
    }
    
    System.out.println(); //spacing
    
    System.out.println("what is ur hair color?");
    String hair = scan.nextLine();
    
    if(hair.equalsIgnoreCase("black") || hair.equalsIgnoreCase("blue"))
    {
      System.out.println("cool hair color");
    }
    else
    {
      System.out.println("dye ur hair dude");
    }
    
    /* nested ifs */
    System.out.println("do u like gum? (truse/false)")
    boolean gum = scan.nextBoolean();
    
    if(gum) //booleans are assumed true
    {
      System.out.println("you like gum. do you like spearmint? (true/false)");
      boolean spearming = scan.nextBoolean();
      
      if(!spearmint) // ! means not
      {
        System.out.println("you dont like spearmint. do you like peppermint instead?");
        boolean peppermint = scan.nextBoolean();
        
        if(peppermint)
        {
          System.out.println("here is some peppermint gum");
        }
        else
        {
          System.out.println("u suck")
        }
      }
      else
      {
        System.out.println("W - you like spearmint");
      }
    }
    else
    {
      System.out.println("ur an extreme loser");
    }
  } 
}