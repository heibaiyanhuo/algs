package leetcode.problems;

import java.util.Arrays;

public class A041_First_Missing_Positive {

    private int firstMissingPositive(int[] nums) {
        if (nums == null) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (0 < nums[i] && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != (i + 1)) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        A041_First_Missing_Positive solution = new A041_First_Missing_Positive();
        int[] a = {3, 4, -1, 1};
        System.out.println(solution.firstMissingPositive(a));
    }
}
