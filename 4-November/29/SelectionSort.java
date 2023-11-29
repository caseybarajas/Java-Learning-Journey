/* 11/29/2023
 * Casey Barajas
 * SelectionSort.java
 * 
 * Selection sort is a simple sorting algorithm that works by repeatedly finding the minimum element from the 
 * unsorted part of an array and placing it at the beginning
 */

import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        
        System.out.print("Enter the type of elements (ints/strings): ");
        String type = scanner.nextLine();
        
        if (type.equalsIgnoreCase("ints")) {
            int[] arr = new int[n];
            System.out.println("Enter the elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            
            System.out.println("Original array:");
            printArray(arr);

            selectionSort(arr);
            
            System.out.println("Sorted array:");
            printArray(arr);
        } else if (type.equalsIgnoreCase("strings")) {
            String[] arr = new String[n];
            System.out.println("Enter the elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextLine();
            }
            
            System.out.println("Original array:");
            printArray(arr);

            selectionSort(arr);
            
            System.out.println("Sorted array:");
            printArray(arr);
        } else {
            System.out.println("Invalid type. Please enter 'ints' or 'strings'.");
        }
        
        scanner.close();
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
            System.out.println("After iteration " + (i + 1) + ":");
            printArray(arr);
        }
    }
    
    public static void selectionSort(String[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
            System.out.println("After iteration " + (i + 1) + ":");
            printArray(arr);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    public static void printArray(String[] arr) {
        for (String str : arr) {
            System.out.print(str + " ");
        }
        System.out.println();
    }
}
