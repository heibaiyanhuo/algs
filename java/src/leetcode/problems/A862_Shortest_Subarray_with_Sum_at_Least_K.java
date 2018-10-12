package leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class A862_Shortest_Subarray_with_Sum_at_Least_K {

    public int shortestSubarray(int[] nums, int K) {
        int N = nums.length, res = N + 1;
        int[] sums = new int[N + 1];
        for (int i = 0; i < N; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N + 1; i++) {
            while (deque.size() > 0 && sums[i] - sums[deque.peekFirst()] >=  K)
                res = Math.min(res, i - deque.pollFirst());
            while (deque.size() > 0 && sums[i] <= sums[deque.peekLast()]) deque.pollLast();
            deque.offerLast(i);
        }
        return res <= N ? res : -1;
    }
}
