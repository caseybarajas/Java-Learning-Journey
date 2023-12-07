/**
 * GnomeSort
 */
public class GnomeSort {
    public static void main(String[] args) {
        int count = 1;
        int nums[] = {7, -5, 3, 2, 1, 0, 45};
        System.out.println("Original Array: ");
        for(int p : nums)
        {
            System.out.print(p + "");
        }

        int i = 1;
        int j = 2;

        while ( i < nums.length) 
        {
            if(nums[i-1] <= nums[i])
            {
                i = j;
                j++;
                System.out.println("hi");
            }
            else
            {
                int temp = nums[i-1];
                nums[i-1] = nums[i];
                nums[i] = temp;
                i--;
                if(i == 0)
                {
                    i = j;
                    j++;
                }

            }
            System.out.println("Iteration " + count + ": ");
            for(int p : nums)
            {
                System.out.print(p + "");
            }
            count++;
            
        }
    }
}