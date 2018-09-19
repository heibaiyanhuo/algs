package leetcode.problems;

public class A042_Trapping_Rain_Water {

    public int trap(int[] height) {
        if (height == null || height.length < 2) return 0;
        int leftMax = 0, rightMax = 0;
        int res = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            leftMax = Math.max(height[l], leftMax);
            rightMax = Math.max(height[r], rightMax);
            if (leftMax > rightMax) {
                res += (rightMax - height[r--]);
            } else {
                res += (leftMax - height[l++]);
            }
        }
        return res;
    }
}
