package two_sum_alogorithm;

import java.util.Arrays;

public class Sort_Binary_Search_Two_Sum_Approach {
    // Function to perform binary search
    static boolean binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return true;
            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }

    /**
     * Function to check whether any pair exists
     * Whose sum is equal to the given target value
     */
    static boolean twoSum(int[] arr, int target) {
        // Sort the array
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        // Iterate through each element in the array
        for (int i =0; i < arr.length; i++) {
            int complement = target - arr[i];

            // Use binary search to find the complement
            if (binarySearch(arr, i + 1, arr.length - 1, complement))
                return true;
        }
        // If no pair return false
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 0, -1, 2, -3, 1 };
        int target = -2;

        if (twoSum(arr, target)) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
}
