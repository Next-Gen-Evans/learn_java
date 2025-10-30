package two_sum_alogorithm;

import java.util.HashSet;

class Hash_Set_Two_Sum {

    static boolean twoSum(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;

            if (set.contains(complement)) return true;

            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 0, -1, 2, -3, 1 };
        int target = -2;

        System.out.println(twoSum(arr, target));
    }
}