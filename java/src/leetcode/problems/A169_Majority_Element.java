package leetcode.problems;

public class A169_Majority_Element {

    public int majorityElement(int[] nums) {

        int major = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                major = nums[i];
                count = 1;
            } else if (major == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        return major;
    }
}
