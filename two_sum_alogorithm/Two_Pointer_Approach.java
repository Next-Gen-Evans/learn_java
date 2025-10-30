package two_sum_alogorithm;

import java.util.Arrays;

class Two_Pointer_Approach {

    static boolean twoSum(int[] arr, int target) {
        Arrays.sort(arr);

        int left = 0, right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) return true;
            else if (sum < target) left++;
            else right--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 0, -1, 2, -3, 1 };
        int target = -2;

        System.out.println(twoSum(arr, target));
    }
}