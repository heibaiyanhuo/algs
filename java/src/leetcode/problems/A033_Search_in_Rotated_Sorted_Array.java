package leetcode.problems;

public class A033_Search_in_Rotated_Sorted_Array {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int lo = 0;
        int hi = nums.length - 1;

        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                if (nums[mid] <= nums[lo] || target >= nums[lo]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (nums[mid] > nums[lo] || target < nums[lo]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        if (nums[lo] == target) {
            return lo;
        }

        if (lo < nums.length - 1 && nums[lo + 1] == target) {
            return lo + 1;
        }

        return -1;
    }
}
