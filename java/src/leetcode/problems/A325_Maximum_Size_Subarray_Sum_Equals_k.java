package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class A325_Maximum_Size_Subarray_Sum_Equals_k {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] sum = new int[nums.length + 1];
        int l = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            map.put(sum[i], i);
        }

        for (int i = 0; i <= nums.length; i++) {
            if (map.containsKey(k + sum[i])) {
                l = Math.max(map.get(k + sum[i]) - i, l);
            }
        }
        return l;
    }
}
