package leetcode.problems;

public class A152_Maximum_Product_Subarray {
    private int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 1;
        int min = 1;
        int res = Integer.MIN_VALUE;
        for (int num: nums) {
            if (num < 0) {
                int tmp = min;
                min = max;
                max = tmp;
            }
            min = Math.min(min * num, num);
            max = Math.max(max * num, num);
            res = Math.max(res, max);
        }
        return res;
    }
}
