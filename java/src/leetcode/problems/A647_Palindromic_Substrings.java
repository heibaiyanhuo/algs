package leetcode.problems;

public class A647_Palindromic_Substrings {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        int N = s.length();
        boolean[][] dp = new boolean[N][N + 1];

        for (int i = N - 1; i >= 0; i--) {
            for (int j = i + 1; j <= N; j++) {
                if (s.charAt(i) == s.charAt(j - 1) && ((j - i <= 3 || dp[i + 1][j - 1]))) {
                    dp[i][j] = true;
                }
                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
