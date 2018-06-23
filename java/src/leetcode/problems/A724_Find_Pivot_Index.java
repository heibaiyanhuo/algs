package leetcode.problems;

public class A724_Find_Pivot_Index {
    private int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int sum = 0, left = 0;
        for (int n: nums) {
            sum += n;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                left += nums[i - 1];
            }
            if (sum - left - nums[i] == left) {
                return i;
            }
        }

        return -1;
    }
}
