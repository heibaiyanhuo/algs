package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class A496_Next_Greater_Element_I {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            pos.put(nums1[i], i);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                int min = stack.pop();
                res[pos.get(min)] = nums2[i];
            }
            if (pos.containsKey(nums2[i])) {
                stack.push(nums2[i]);
            }
        }
        return res;
    }
}
