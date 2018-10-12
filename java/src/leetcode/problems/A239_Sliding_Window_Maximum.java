package leetcode.problems;

import java.util.*;

public class A239_Sliding_Window_Maximum {

    private int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int l = nums.length;
        int[] res = new int[l - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int p = 0;
        for (int i = 0; i < l; i++) {
            System.out.println(deque);
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                res[p++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        A239_Sliding_Window_Maximum solution = new A239_Sliding_Window_Maximum();
        int[] nums = {4, 3, 2};
        System.out.println(Arrays.toString(solution.maxSlidingWindow(nums, 2)));
    }
}
