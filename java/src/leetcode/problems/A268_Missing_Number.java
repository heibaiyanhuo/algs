package leetcode.problems;

public class A268_Missing_Number {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for (int num: nums) {
            sum -= num;
        }
        return sum;
    }
}
