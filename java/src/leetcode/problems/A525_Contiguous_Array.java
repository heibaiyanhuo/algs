package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class A525_Contiguous_Array {

    public int findMaxLength(int[] nums) {
        int diff = 0;
        int l = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            diff += (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(diff)) {
                l = Math.max(l, i - map.get(diff));
            } else {
                map.put(diff, i);
            }
        }
        return l;
    }
}
