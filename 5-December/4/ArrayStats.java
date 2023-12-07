import java.util.Scanner;
import java.util.Arrays;

public class ArrayStats
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    
    //array of doubles
    double[] bigMac = {4, 5.39, -5.39, 37, 4229, 9999.9, 12187, 33, 4};
    
    //sort the array from least to greatest
    Arrays.sort(bigMac);
    System.out.println("sorted array:\n" + Arrays.toString(bigMac) + "\n");
    
    //minimum - since the array is sorted, the index on the minimum is 0
    double min = bigMac[0];
    System.out.println("minimum: " + min);
    
    //maximum - the final index
    double max = bigMac[bigMac.length - 1];
    System.out.println("maximum: " + max);
    
    System.out.println(); //spacing
    
    //mean (average) - add all things, divide by ammount
    double sum = 0;
    for(double num : bigMac)
    {
      sum += num;
    }
    double mean = sum / bigMac.length;
    System.out.println("mean: " + mean);
    
    System.out.printf("mean: %.2f\n", mean);
    
    //stats -> round not truncate
    System.out.println(); //spacing
    
    //median - the middle value -> depende on number of elements
    //check number of elements
    double median = 0;
    if(bigMac.length % 2 == 0) //is length an even number
    {
      //add the two middle elements and divide them by 2
      double firstMid = bigMac[bigMac.length / 2 - 1];
      double secondMid = bigMac[bigMac.length / 2];
      median = (firstMid + secondMid) / 2;
    }
    else //get the middle element
    {
      median = bigMac[bigMac.length / 2];
    }
    System.out.println("median: " + median);
    
    System.out.println(); //spacing
    
    //mode - the element that occurs the most
    double mode = 0; //data type same as the array
    int modeCount = 0; //the hightst count for an element
    for(int i = 0; i < bigMac.length; i++)
    {
      int count = 0; //the count of this element
      for(double n : bigMac)
      {
        if(bigMac[i] == n)
        {
          count++;
        }
        
        if(count > modeCount) //if the current element count is bigger than maxCount
        {
          modeCount = count;
          mode = bigMac[i];
        }
      }
    }
    
    //there is not always a mode
    if(modeCount == 1)
    {
      System.out.println("there is no mode");
    }
    else
    {
      System.out.println("mode: " + mode);
    }
  }
}
