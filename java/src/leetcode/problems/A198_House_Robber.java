package leetcode.problems;

public class A198_House_Robber {

    public int rob(int[] nums) {
        int curr = 0;
        int prev = 0;
        for (int n: nums) {
            int tmp = curr;
            curr = Math.max(curr, n + prev);
            prev = tmp;
        }
        return curr;

    }
}
