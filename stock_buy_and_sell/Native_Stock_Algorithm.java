package stock_buy_and_sell;

public class Native_Stock_Algorithm {
    static int maxProfit(int[] prices) {
        int n = prices.length;
        int res = 0;

        // Explore all possible ways to buy and sell stock
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++ ) {
                res = Math.max(res, prices[j] - prices[i]);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] prices = { 7, 10, 1, 3, 6, 9, 2 };
        System.out.println(maxProfit(prices));
    }
}
