# Two Sum - Pair with Given Sum

## Problem Statement
Given an array `arr[]` of `n` integers and a target value, the task is to find whether there is a pair of elements in the array whose sum is equal to the target. This problem is a variation of the "Two Sum" problem.

### Examples

**Input:**
```java
arr[] = [0, -1, 2, -3, 1], target = -2
```
**Output:**
```
true
```
**Explanation:** There is a pair (1, -3) with the sum equal to the target: `1 + (-3) = -2`.

**Input:**
```java
arr[] = [1, -2, 1, 0, 5], target = 0
```
**Output:**
```
false
```
**Explanation:** There is no pair with the sum equal to the given target.

## Table of Contents
1. [Naive Approach](#naive-approach)
2. [Better Approach 1: Sorting and Binary Search](#better-approach-1-sorting-and-binary-search)
3. [Better Approach 2: Sorting and Two-Pointer Technique](#better-approach-2-sorting-and-two-pointer-technique)
4. [Expected Approach: Using Hash Set](#expected-approach-using-hash-set)

## Naive Approach

### Explanation
The basic approach is to generate all possible pairs and check if their sum equals the target. This involves two nested loops.

### Java Code
```java
class GfG {

    static boolean twoSum(int[] arr, int target) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 0, -1, 2, -3, 1 };
        int target = -2;

        System.out.println(twoSum(arr, target));
    }
}
```
### Output
```
true
```
### Complexity Analysis
- **Time Complexity:** `O(n^2)`
- **Auxiliary Space:** `O(1)`

## Better Approach 1: Sorting and Binary Search

### Explanation
1. Sort the array.
2. For each element, calculate the complement (target - current element).
3. Use binary search to find the complement in the subarray.

### Java Code
```java
import java.util.Arrays;

class GfG {

    static boolean binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) return true;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    static boolean twoSum(int[] arr, int target) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            if (binarySearch(arr, i + 1, arr.length - 1, complement)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 0, -1, 2, -3, 1 };
        int target = -2;

        System.out.println(twoSum(arr, target));
    }
}
```
### Output
```
true
```
### Complexity Analysis
- **Time Complexity:** `O(n * log(n))` (due to sorting and binary search)
- **Auxiliary Space:** `O(1)`

## Better Approach 2: Sorting and Two-Pointer Technique

### Explanation
1. Sort the array.
2. Use two pointers (one from the beginning, another from the end).
3. Adjust the pointers based on the sum comparison.

### Java Code
```java
import java.util.Arrays;

class GfG {

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
```
### Output
```
true
```
### Complexity Analysis
- **Time Complexity:** `O(n * log(n))` (due to sorting)
- **Auxiliary Space:** `O(1)`

## Expected Approach: Using Hash Set

### Explanation
1. Use a `HashSet` to track elements we've seen.
2. For each element, calculate its complement.
3. If the complement exists in the `HashSet`, we found the pair.

### Java Code
```java
import java.util.HashSet;

class GfG {

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
```
### Output
```
true
```
### Complexity Analysis
- **Time Complexity:** `O(n)` (single pass through the array)
- **Auxiliary Space:** `O(n)` (for storing elements in the `HashSet`)

## Contribution
Feel free to contribute by improving the code, optimizing further, or adding new approaches.


Happy Coding! 🚀

