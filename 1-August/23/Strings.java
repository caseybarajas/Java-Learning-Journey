/* Casey Barajas
* Strings
* 8/23
* In-Class Notes
*/

public class Strings
{
  public static void main(String[] args)
  {
    /* String concatenation */
    String firstName = "casey";
    String lastName = "sounthonevichith";
    
    //first way | .concat()
    String fullName = firstName.concat(lastName); //puts one right after another
    System.out.println("my name is " + fullName); //does not change the value of either String
    
    System.out.println(); //spacing
    
    //second way 
    String fullMiddle = firstName + " bradford knowlton " + lastName;
    System.out.println("my full name is " + fullMiddle);
    
    System.out.println(); //spacing
    
    //third way | changes the String *adds to the end
    firstName += "pie";
    System.out.println("my nickname is " + firstName);
    
    System.out.println(); //spacing
    
    /* escape sequences */
    
    //new line | \n
    System.out.println("i like color green \ni'm tyler sounthonevichith \ni am very mean\n");
    
    //slash | \\
    String date = "8\\23\\23";
    System.out.println("today's date is " + date);
    
    System.out.println(); //spacing

    //quote | 
    String quote = "\"i am become death, destroyer of worlds\"";
    System.out.println(quote);
    
    System.out.println(); //spacing
    
    /* String methods */
    
    //.length(  ) tells the length of a string
    int letterCount = firstName.length(); //get length of first name variable
    System.out.println(firstName + " has " + letterCount + " letters");
    System.out.println(lastName + " has " + lastName.length() + " letters");
    
    System.out.println(); //spacing
    
    //.equals(  ) tells if they are the same string
    String friendName = "jack";
    String friendTwo = "jade";
    
    boolean isSame = friendName.equals(friendTwo);
    System.out.println("jack & jade have the same name: " + isSame);
    System.out.println("jack & jack have the same name: " + friendName.equals("jack"));
    
    System.out.println(); //spacing
    
    //.substring(int) *int is starting place > goes to the end
    String nickName = firstName.substring(3); //starts at position 3 and goes to the end
    System.out.println("casey's nickname is " + nickName);

    //.substring(int, int)
    String nickNameTwo = firstName.substring(0, 4);
    System.out.println("casey's nickname is " + nickNameTwo);
    
    System.out.println(); //spacing
    
    //.indexOf(String)
    String school = "high school";
    String city = "city";
    
    int location = school.indexOf(city); //the index of city in school
    System.out.println("high school has the city at index " + location);
    System.out.println("high school has the number at " + school.indexOf("1201"));
    //returns -1 if the string is not found
    
  }
}


