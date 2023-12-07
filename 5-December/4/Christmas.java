import java.util.Scanner;

public class Christmas
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    String[] people = new String[10];
    String[] presents = new String[people.length];
    
    for(int i = 0; i < people.length; i++)
    {
      System.out.println("what is your name?");
      String person = scan.nextLine().toLowerCase();
      people[i] = person;
      
      System.out.println("what do you want for christmas?");
      presents[i] = scan.nextLine().toLowerCase();
      
      System.out.println(); //spacing
    }
    
    System.out.println("kids and their wishes: ");
    int presentCounter = 0;
    
    for(String s : people) //for each string in people
    {
      System.out.println(s + " wants " + presents[presentCounter]);
      presentCounter++;
    }
    
    System.out.println(); //spacing
    
    int[] ages = new int[people.length];
    int i = 0; //counter
    
    for(String s : people)
    {
      System.out.println(s + ", how old are you?");
      ages[i] = scan.nextInt();
      i++;
    }
    
    System.out.println(); //spacing
    
    System.out.println("summary:\n");
    
    for(int j = 0; j < people.length; j++)
    {
      System.out.println(people[j] + "(" + ages[j] + ") wants " + presents[j]);
    }
  }
}
