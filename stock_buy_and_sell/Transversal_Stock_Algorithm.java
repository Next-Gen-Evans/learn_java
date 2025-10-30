package stock_buy_and_sell;

public class Transversal_Stock_Algorithm {

    static int maxProfit(int[] prices) {
        int minSoFar = prices[0];
        int res = 0;

        /**
         * Update the minimum value seen so far
         * If we see smaller
         */
        for (int i = 1; i < prices.length; i++) {
            minSoFar = Math.min(minSoFar, prices[i]);

            // Update result if we got more profit
            res = Math.max(res, prices[i] - minSoFar);
        }
        return res;
    }
}
