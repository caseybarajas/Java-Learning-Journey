/* Casey
* classes
* 9/25/23
* In-Class Notes
*/

public class Classroom
{
  public static void main(String[] args)
  {
    
    //created student objects
    
    Student tyler = new Student(); //student with default attributes
    Student casey = new Student("casey", 15, 10); //student with given attributes
    
    casey.doHomework();
    tyler.doHomework();
    
    casey.setGPA(2.6); //set casey's gpa to 2.6
    double caseyGPA = casey.getGPA();
    System.out.println("casey's gpa is " + caseyGPA);
    System.out.println(casey.getGPA()); //call method inside output
    
    //print out the details of an object
    System.out.println(casey); //Student33909752 (without toString shows cpu location)
    
  }
  
}