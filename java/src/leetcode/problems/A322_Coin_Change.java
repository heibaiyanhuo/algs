package leetcode.problems;


import java.util.Arrays;

public class A322_Coin_Change {

    int res = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }


    public int coinChange2(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }

        Arrays.sort(coins);
        dfs(coins, amount, coins.length - 1, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void dfs(int[] coins, int amount, int idx, int count) {
        if (amount == 0) {
            res = Math.min(res, count);
            return;
        }

        if (idx < 0) {
            return;
        }

        int number = amount / coins[idx];
        for (int i = number; i >= 1; i--) {
            if (count + i < res) {
                dfs(coins, amount - i * coins[idx], idx - 1, count + i);
            } else {
                break;
            }
        }
    }


    public static void main(String[] args) {
        A322_Coin_Change solution = new A322_Coin_Change();
        System.out.println(solution.coinChange2(new int[]{2}, 1));
    }
}

