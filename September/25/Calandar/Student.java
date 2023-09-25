/* Casey
* Student class
* works with Classroom.java
* 9/25/23
* In-Class Notes
*/

import java.util.Scanner;

public class Student
{
  // class variables
  public String name;
  public int age;
  public int gradeLevel;
  public boolean wearsGlasses;
  public String house;
  private double gpa;
  Scanner scan = new Scanner(System.in);
  
  //noArgs constructor
  public Student()
  {
    //default value >
    this.gpa = 4.0; //this. for that object
    
    //or ask questions
    System.out.println("what is ur name");
    this.name = scan.nextLine();
    System.out.println(this.name);
    
  }
  
  //parameterized constructor
  public Student(String n, int a, int g) //parameters
  {
    //set object's value = parameters
    this.name = n;
    this.age = a;
    this.gradeLevel = g;
  }
  
  //do homework
  public void doHomework() //void does not return
  {
    System.out.println(name + ": homework done.");
  }
  
  //setter
  public void setGPA(double gpaScore)
  {
    gpa = gpaScore; //sets gpa = parameter
  }
  
  //getter
  public double getGPA()
  {
    return gpa; //give the gpa to the main class
  }
  
  public String toString()
  {
    return "name: " + name + "\nage: " + age
     + "\ngrade: " + gradeLevel + "\nglasses: " + wearsGlasses 
     + "\nhouse: " + house + "\ngpa: " + gpa;
  }
  
}





