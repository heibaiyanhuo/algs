package leetcode.problems;

public class A121_Best_Time_to_Buy_and_Sell_Stock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        int currMin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            currMin = Math.min(currMin, prices[i]);
            max = Math.max(prices[i] - currMin, max);
        }

        return max;
    }
}
