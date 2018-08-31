package leetcode.problems;

public class A674_Longest_Continuous_Increasing_Subsequence {

    private int findLengthOfLCIS(int[] nums) {

        int max = 0;
        int i = 0;
        while (i < nums.length) {
            int j = i + 1;
            while (j < nums.length && nums[j] > nums[j - 1]) {
                j++;
            }
            max = Math.max(j - i, max);
            i = j;
        }
        return max;
    }
}
