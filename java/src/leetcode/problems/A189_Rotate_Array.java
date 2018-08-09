package leetcode.problems;

import java.util.Arrays;

public class A189_Rotate_Array {

    public void rotate(int[] nums, int k) {
        int l = nums.length;
        int[] aux = Arrays.copyOf(nums, l);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = aux[(i + l - k % l) % l];
        }
    }
}
