package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class A523_Continuous_Subarray_Sum {
    private boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        if (k == 0) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 0 && nums[i - 1] == 0) {
                    return true;
                }
            }
            return false;
        }
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 1; i <= nums.length; i++) {
            sum = (sum + nums[i - 1]) % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) return true;
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}
