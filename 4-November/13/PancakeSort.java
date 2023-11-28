import java.util.Scanner;
import java.util.Comparator;

public class PancakeSort<T> {

    private Comparator<T> comparator;

    public PancakeSort(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    // Flip function to reverse the array from 0 to i
    void flip(T[] arr, int i) {
        T temp;
        int start = 0;
        while (start < i) {
            temp = arr[start];
            arr[start] = arr[i];
            arr[i] = temp;
            start++;
            i--;
        }
    }

    // Function to find the index of the maximum element
    int findMax(T[] arr, int n) {
        int mi, i;
        for (mi = 0, i = 0; i < n; ++i) {
            if (comparator.compare(arr[i], arr[mi]) > 0) {
                mi = i;
            }
        }
        return mi;
    }

    // The main function that sorts the given array using flip operations
    void pancakeSort(T[] arr, int n) {
        for (int curr_size = n; curr_size > 1; --curr_size) {
            int mi = findMax(arr, curr_size);
            if (mi != curr_size - 1) {
                flip(arr, mi);
                flip(arr, curr_size - 1);
            }
            printArray(arr); // Print array after each flip
        }
    }

    // Function to print an array
    void printArray(T[] arr) {
        for (T value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the data type (1: Integers, 2: Doubles, 3: Strings):");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                handleIntegers(scanner);
                break;
            case 2:
                handleDoubles(scanner);
                break;
            case 3:
                handleStrings(scanner);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    private static void handleIntegers(Scanner scanner) {
        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();
        Integer[] arr = new Integer[n];
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        PancakeSort<Integer> sorter = new PancakeSort<>(Integer::compare);
        sorter.pancakeSort(arr, n);
        System.out.println("Sorted Array:");
        sorter.printArray(arr);
    }

    private static void handleDoubles(Scanner scanner) {
        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();
        Double[] arr = new Double[n];
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextDouble();
        }
        PancakeSort<Double> sorter = new PancakeSort<>(Double::compare);
        sorter.pancakeSort(arr, n);
        System.out.println("Sorted Array:");
        sorter.printArray(arr);
    }

    private static void handleStrings(Scanner scanner) {
        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        String[] arr = new String[n];
        System.out.println("Enter " + n + " strings:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLine();
        }
        PancakeSort<String> sorter = new PancakeSort<>(String::compareTo);
        sorter.pancakeSort(arr, n);
        System.out.println("Sorted Array:");
        sorter.printArray(arr);
    }
}
