package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int N = triangle.size();
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = triangle.get(0).get(0);

        for (int i = 2; i <= N; i++) {
            for (int j = i; j >= 1; j--) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i - 1).get(j - 1);
            }
        }
        int min = dp[1];
        for (int i = 2; i <= N; i++) {
            min = Math.min(dp[i], min);
        }

        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(Arrays.asList(2)));
        result.add(new ArrayList<>(Arrays.asList(3, 4)));
        result.add(new ArrayList<>(Arrays.asList(6, 5, 7)));
        result.add(new ArrayList<>(Arrays.asList(4, 1, 8, 3)));
        A120_Triangle solution = new A120_Triangle();
        System.out.println(solution.minimumTotal(result));
    }
}
