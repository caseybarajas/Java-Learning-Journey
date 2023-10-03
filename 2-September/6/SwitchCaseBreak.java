/*
* Casey Barajas
* switch-case-break
* 9/6/23
* Notes
*/
import java.util.Scanner;

public class SwitchCaseBreak
{
  public static void main(String[] args)
  {
    /* like if, elseif, but for more specific values */
    
    Scanner scan = new Scanner(System.in);
    
    System.out.println("how old are u?");
    int age = scan.nextInt();
    
    switch(age) //switch(variable)
    {
      case 1:   //case "option"
        System.out.println("why? how?");
        break;  //break out of switch
        
      case 10:
        System.out.println("double digits");
        break;
        
      case 16:
        System.out.println("u can drive. dont crash");
        break; //last case does not need a break
    }
    
    System.out.println("exit switch"); //confirm exit switch
    System.out.println(); //spacing
    scan.nextLine(); //empty the scanner
    
    /* multiple cases with the same result */
    System.out.println("what day is it?");
    String day = scan.nextLine().toLowerCase();
    
    switch(day)
    {
      case "sunday":
      case "saturday":
        System.out.println("weekend!");
        break;
      
      case "monday":
      case "tuesday":
      case "wednesday":
      case "thursday":
      case "friday":
        System.out.println("weekday :(");
        break;
    }
    
    System.out.println("exit switch");
    System.out.println(); //spacing
    
    /* default case */ //like the "else"
    System.out.println("what class are you in?");
    String course = scan.nextLine().toLowerCase();
    
    switch(course)
    {
      case "math":
        System.out.println("imagine");
        break;
        
      case "english":
        System.out.println("ew");
        break;
        
      case "science":
        System.out.println("fire");
        break;
        
      default:
        System.out.println("what course is that?");
        break;
    }
    
    System.out.println("exit switch");
    System.out.println(); //spacing
    
    /* nested switches */
    int counter = 0;
    
    System.out.println("what is ur favorite color?");
    String color = scan.nextLine().toLowerCase();
    
    switch(color)
    {
      case "purple":
        System.out.println("grapes");
        System.out.println("whats ur fav grape?");
        String grape = scan.nextLine().toLowerCase();
        
        switch(grape)
        {
          case "green":
            System.out.println("womp womp");
            break;
            
          case "purple":
            System.out.println("best color");
            break;
            
          default:
            System.out.println("what other colors are there?");
            break;
        }
        
        break; //purple case break
        
      case "white":
        System.out.println("is it every color or no color?");
        String colorTwo = scan.nextLine().toLowerCase();
        
        switch(colorTwo)
        {
          case "every color":
            System.out.println("pick one color");
            break;
            
          case "no color":
            System.out.println("ur lying!!");
            break;
            
          default:
            System.out.println("what is ur least fav color?");
            String leastColor = scan.nextLine().toLowerCase();
            
            switch(leastColor)
            {
              case "yellow":
                System.out.println("sun");
                break;
                
              case "brown":
                System.out.println("dirt");
                break;
            }
        }
        break; //break white case
        
      default:
        System.out.println("nobody likes that color");
        break;
    }
  }
}





