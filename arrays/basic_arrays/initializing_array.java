package arrays.basic_arrays;

import java.util.stream.IntStream;

public class initializing_array {
    

    public static void main(String[] args) {

        // an array of integers using range method
        int[] arr1 = IntStream.range(1, 5).toArray();
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }

        System.out.print('\n');

        // an array of integers using
        // IntStream.rangeClosed() method
        int[] arr2 = IntStream.rangeClosed(1, 4).toArray();
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }

        System.out.print('\n');

        int[] arr3 = IntStream.of(1, 2, 3, 4).toArray();
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }

        System.out.print('\n');


    }
}
