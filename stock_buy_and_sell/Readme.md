# 📈 Stock Buy and Sell – Max One Transaction Allowed

## 📝 Problem Statement
Given an array `prices[]` of length **N**, representing the prices of stocks on different days, the task is to find the **maximum profit** possible by performing **at most one transaction** (1 buy + 1 sell).

**Note:** You must buy the stock before you sell it.

### 📊 Examples

#### Example 1
```java
Input: prices[] = {7, 10, 1, 3, 6, 9, 2}
Output: 8
Explanation: Buy at price 1 and sell at price 9.
```

#### Example 2
```java
Input: prices[] = {7, 6, 4, 3, 1}
Output: 0
Explanation: No profitable transaction is possible.
```

#### Example 3
```java
Input: prices[] = {1, 3, 6, 9, 11}
Output: 10
Explanation: Buy at price 1 and sell at price 11.
```

---

## 📚 Table of Contents

1. [Naive Approach – O(n^2) Time](#1-naive-approach)
2. [Optimized Approach – O(n) Time](#2-optimized-approach)

---

## 1. 🐢 Naive Approach – O(n^2) Time
The brute-force method explores all possible pairs of buy and sell days.

### 🧠 Approach
1. Use two nested loops to simulate buying and selling on every possible day.
2. Calculate the difference between the selling and buying prices.
3. Keep track of the maximum profit encountered.

### 📜 Code (Java)
```java
// Java Program to find maximum profit using brute-force approach
class Native_Stock_Algorithm {

    static int maxProfit(int[] prices) {
        int n = prices.length;
        int res = 0;

        // Explore all possible buy-sell pairs
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                res = Math.max(res, prices[j] - prices[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = {7, 10, 1, 3, 6, 9, 2};
        System.out.println(maxProfit(prices)); // Output: 8
    }
}
```

### 📊 Complexity Analysis
- **Time Complexity:** `O(n^2)` – Due to nested loops.
- **Space Complexity:** `O(1)` – No extra space is used.

---

## 2. 🚀 Optimized Approach – O(n) Time
The optimized solution involves a **single traversal** of the array.

### 🧠 Approach
1. Maintain a variable to track the **minimum price** so far.
2. At each price, compute the **potential profit** if sold at the current day.
3. Update the **maximum profit** if the current profit exceeds it.

### 📜 Code (Java)
```java
// Java Program to find maximum profit using optimized approach
class Transversal_Stock_Algorithm {

    static int maxProfit(int[] prices) {
        int minSoFar = prices[0];
        int res = 0;

        for (int i = 1; i < prices.length; i++) {
            minSoFar = Math.min(minSoFar, prices[i]);
            res = Math.max(res, prices[i] - minSoFar);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = {7, 10, 1, 3, 6, 9, 2};
        System.out.println(maxProfit(prices)); // Output: 8
    }
}
```

### 📊 Complexity Analysis
- **Time Complexity:** `O(n)` – Single pass through the array.
- **Space Complexity:** `O(1)` – No extra space is required.

---

## 🧪 Test Cases
| Input                          | Output | Explanation                           |
|--------------------------------|--------|---------------------------------------|
| `{7, 10, 1, 3, 6, 9, 2}`       | `8`    | Buy at 1, sell at 9.                 |
| `{7, 6, 4, 3, 1}`              | `0`    | No profitable transaction possible.   |
| `{1, 3, 6, 9, 11}`             | `10`   | Buy at 1, sell at 11.                |
| `{3, 2, 6, 5, 0, 3}`           | `3`    | Buy at 0, sell at 3.                 |

-
## ⭐ Acknowledgements
- [GeeksforGeeks – Stock Buy and Sell Problem](https://www.geeksforgeeks.org/)

If you found this helpful, give it a ⭐ on GitHub!

