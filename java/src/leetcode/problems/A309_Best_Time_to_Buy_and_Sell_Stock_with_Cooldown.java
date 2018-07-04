package leetcode.problems;

public class A309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        // buy[0]: Max profit with a stock at the end of today
        // buy[1]: Max profit with a stock at the end of yesterday
        int[] buy = new int[2];
        buy[0] = -prices[0];
        // sell[0]: Max profit without stock at the end of today
        // sell[1]: Max profit without stock at the end of yesterday
        int[] sell = new int[2];
        for (int i = 1; i < prices.length; i++) {
            buy[1] = buy[0];
            buy[0] = Math.max(buy[0], sell[1] - prices[i]);

            sell[1] = sell[0];
            sell[0] = Math.max(sell[0], buy[1] + prices[i]);
        }
        return sell[0];
    }
}
