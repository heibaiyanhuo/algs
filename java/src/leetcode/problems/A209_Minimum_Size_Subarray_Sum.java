package leetcode.problems;

import java.util.Arrays;

public class A209_Minimum_Size_Subarray_Sum {

    // O(n) solution
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int minLength = Integer.MAX_VALUE;
        int i = 0;
        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= s) {
                minLength = Math.min(minLength, j - i + 1);
                sum -= nums[i++];
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }


    // O(nlogn) solution
    public int minSubArrayLen2(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] sum = new int[nums.length + 1];
        int minLength = Integer.MAX_VALUE;

        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            int threshold = sum[i] - s;
            int idx = findClosestIndex(sum, i - 1, threshold);
            if (idx != -1) {
                minLength = Math.min(minLength, i - idx);
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    private int findClosestIndex(int[] arr, int endIdx, int target) {
        int lo = 0;
        int hi = endIdx;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        if (arr[lo + 1] <= target) {
            return lo + 1;
        }
        if (arr[lo] <= target) {
            return lo;
        }
        return -1;
    }

    public static void main(String[] args) {
        A209_Minimum_Size_Subarray_Sum solution = new A209_Minimum_Size_Subarray_Sum();
        int[] a = {2,3,1,2,4,3};
        System.out.println(solution.minSubArrayLen2(7, a));
    }
}
