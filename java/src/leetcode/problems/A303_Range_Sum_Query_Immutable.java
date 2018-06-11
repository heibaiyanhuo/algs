package leetcode.problems;

public class A303_Range_Sum_Query_Immutable {

    private int[] sumArr;

    public A303_Range_Sum_Query_Immutable(int[] nums) {
        sumArr = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sumArr[i + 1] = nums[i] + sumArr[i];
        }
    }

    public int sumRange(int i, int j) {
        return sumArr[j + 1] - sumArr[i];
    }
}
