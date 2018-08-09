package leetcode.problems;

public class A287_Find_the_Duplicate_Number {

    private int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        for (int i = 1; i <= n; i++) {
            boolean mark = false;
            for (int j: nums) {
                if (j == i) {
                    if (mark) {
                        return j;
                    }
                    mark = true;
                }
            }
        }
        return 0;
    }

    private int findDuplicate2(int[] nums) {
        int slow = nums[0];
        int fast = nums[slow];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
