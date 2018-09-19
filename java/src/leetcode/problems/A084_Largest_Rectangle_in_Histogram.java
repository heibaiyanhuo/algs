package leetcode.problems;

import java.util.Stack;

public class A084_Largest_Rectangle_in_Histogram {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < heights.length) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i++);
            } else {
                int idx = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                res = Math.max(res, (i - left - 1) * heights[idx]);
            }
        }
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            res = Math.max(res, (i - left - 1) * heights[idx]);
        }

        return res;
    }
}
