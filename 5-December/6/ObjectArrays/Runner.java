/*
 * Casey Barajas
 * Runner.java
 * December 6th, 2023
 */

 import java.util.Scanner;

 public class Runner 
 {
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);

        //create some cheese
        Cheese cheeseOne = new Cheese("Provolone", false, 3, 4.95);
        Cheese cheeseTwo = new Cheese("Swiss", true, 2, 3.95);
        Cheese cheeseThree = new Cheese("Gouda", false, 14, 4000);
        Cheese cheeseFour = new Cheese("Brie", false, 7, 9.99);
        Cheese cheeseFive = new Cheese("Pepper Jack", false, 32, 12.33);


        //make an array of cheeses
        Cheese[] cheeseArray =  {cheeseOne, cheeseTwo, cheeseThree, cheeseFour, cheeseFive};

        for(Cheese c : cheeseArray)
        {
            System.out.println("How old is " + c.type + "?");
            //int cheeseAge = scan.nextInt();
            c.setAge(scan.nextInt());
        }

        for(Cheese c : cheeseArray)
        {
            System.out.println(c + " is " + c.getAge() + " years old.");
        }

        //check for cheese holes
        int cheeseWithHoles = 0; //count of cheeses with holes
        
        System.out.println("Cheeses with holes: ");

        for(Cheese c : cheeseArray)
        {
            if(c.hasHoles)
            {
                System.out.println(c.type);
                cheeseWithHoles++;
            }
        }

        System.out.println("There are " + cheeseWithHoles + " cheeses with holes.");

        System.out.println("");

        for(Cheese c : cheeseArray)
        {
            if(c.price <= 9.99)
            {
                System.out.println("dang thats a sweet deal on " + c.type);
            }
        }
        
    }   
}