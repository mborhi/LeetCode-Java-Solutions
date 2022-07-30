/**
 * LeetCode solution for 121. Best Time to Buy and Sell Stock:
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class Solution {

    /**
     * Finds the best time to buy and sell a stock from array of stock prices
     * <p>
     * Time Complexity: O(N), where N = the number of elements in the given array
     * The lowest buying price updated while passing through the array. If the profit from the current value in the
     * array minus the lowest buying price is greater than the current profit, then the profit is also updated. This
     * can be done with one pass over the array.
     * <p>
     * Space Complexity: O(1)
     *
     * @param prices the array of stock prices
     * @return the maximum possible profit
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyIdx = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[buyIdx]) buyIdx = i;
            profit = Math.max(profit, prices[i] - prices[buyIdx]);
        }
        return profit;
    }

    // exceeds time limit
    public int maxProfitBruteForce(int[] prices) {
        // for every day look at what day makes the best profit
        int highest = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit >= highest) {
                    highest = profit;
                }
            }
        }
        return highest;
    }
}