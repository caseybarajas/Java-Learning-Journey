import java.util.scanner;
import java.util.Arrays;

public class SelectionSort
{
    public static void main(String[] args)
    {
        System.out.println("How many elements do you want in your array")

        Scanner scan = new Scanner(System.in);

        int element = -1

        do
        {
            System.out.println("How many elements do you want in your array");
        }

        try
        {
            String userInput = scan.nextLine();
            element = Integer.parseInt(userInput);

        }
        catch(NumberFormatException e);
        {
            System.out.println("Please enter a valid number");
        }

        while(element < 0);
        
        int[] intArray = new int[element];
        

            
        
    }
}