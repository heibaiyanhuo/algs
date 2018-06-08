package leetcode.problems;

public class A167_Two_Sum_II {

    public int[] twoSum(int[] numbers, int target) {
        int lo = 0;
        int hi = numbers.length - 1;
        while (lo < hi) {
            if (numbers[lo] + numbers[hi] > target) {
                hi--;
            } else if (numbers[lo] + numbers[hi] < target) {
                lo++;
            } else {
                return new int[]{lo + 1, hi + 1};
            }
        }

        return null;
    }
}
