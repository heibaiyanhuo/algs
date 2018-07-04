package leetcode.problems;

public class A714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {

    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int sell = 0; // Max profit: no stock at the end of the day.
        int buy = -prices[0]; // Max profit: with a stock at the end of the day.

        for (int price: prices) {
            int tmp = buy;
            buy = Math.max(buy, sell - price);
            sell = Math.max(sell, tmp + price - fee);
        }

        return sell;
    }
}
