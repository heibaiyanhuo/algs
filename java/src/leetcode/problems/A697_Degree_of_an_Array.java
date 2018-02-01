package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class A697_Degree_of_an_Array {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, int[]> range = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (freq.containsKey(nums[i])) {
                freq.replace(nums[i], freq.get(nums[i]) + 1);
                range.get(nums[i])[1] = i;
            } else {
                freq.put(nums[i], 0);
                range.put(nums[i], new int[]{i, i});
            }
        }
        int degree = -1;
        for (int key: freq.keySet()) {
            degree = Math.max(freq.get(key), degree);
        }
        int res = nums.length;
        for (int key: range.keySet()) {
            if (freq.get(key) == degree) {
                res = Math.min(res, range.get(key)[1] - range.get(key)[0]);
            }
        }

        return res;
    }
}
