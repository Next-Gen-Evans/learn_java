package arrays.advanced_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create and initialize an array
        int[] numbers = {45, 12, 89, 34, 67, 23, 56, 78, 90, 1};
        
        System.out.println("Original Array: " + Arrays.toString(numbers));
        
        // 1. Sorting the array
        Arrays.sort(numbers);
        System.out.println("\nSorted Array: " + Arrays.toString(numbers));
        
        // 2. Binary Search
        System.out.print("\nEnter a number to search: ");
        int searchNum = scanner.nextInt();
        int index = Arrays.binarySearch(numbers, searchNum);
        if (index >= 0) {
            System.out.println("Number found at index: " + index);
        } else {
            System.out.println("Number not found in the array");
        }
        
        // 3. Find maximum and minimum
        int max = numbers[0];
        int min = numbers[0];
        for (int num : numbers) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        System.out.println("\nMaximum value: " + max);
        System.out.println("Minimum value: " + min);
        
        // 4. Calculate average
        double sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double average = sum / numbers.length;
        System.out.println("Average value: " + average);
        
        // 5. Reverse the array
        int[] reversed = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            reversed[i] = numbers[numbers.length - 1 - i];
        }
        System.out.println("\nReversed Array: " + Arrays.toString(reversed));
        
        // 6. Find duplicate elements
        System.out.println("\nFinding duplicates in the array...");
        boolean hasDuplicates = false;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                System.out.println("Duplicate found: " + numbers[i]);
                hasDuplicates = true;
            }
        }
        if (!hasDuplicates) {
            System.out.println("No duplicates found in the array");
        }
        
        // 7. Rotate array elements
        System.out.print("\nEnter number of positions to rotate: ");
        int rotateBy = scanner.nextInt();
        int[] rotated = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            rotated[(i + rotateBy) % numbers.length] = numbers[i];
        }
        System.out.println("Rotated Array: " + Arrays.toString(rotated));
        
        scanner.close();
    }
} 