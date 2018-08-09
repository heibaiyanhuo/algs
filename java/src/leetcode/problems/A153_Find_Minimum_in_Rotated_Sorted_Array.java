package leetcode.problems;

public class A153_Find_Minimum_in_Rotated_Sorted_Array {

    private int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] > nums[lo]) {
                if (nums[mid] > nums[hi]) {
                    lo = mid + 1;
                } else {
                    return nums[lo];
                }
            } else {
                if (nums[mid] > nums[mid - 1]) {
                    hi = mid - 1;
                } else {
                    return nums[mid];
                }
            }
        }
        if (lo == hi) {
            return nums[lo];
        }
        return nums[lo] < nums[lo + 1] ? nums[lo] : nums[lo + 1];
    }

    public static void main(String[] args) {
        A153_Find_Minimum_in_Rotated_Sorted_Array s = new A153_Find_Minimum_in_Rotated_Sorted_Array();
        System.out.println(s.findMin(new int[]{4,5,0,1,2,3}));
    }
}
