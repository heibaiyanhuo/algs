package leetcode.problems;

public class A154_Find_Minimum_in_Rotated_Sorted_Array_II {

    private int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == nums[lo]) {
                lo++;
            } else if (nums[mid] < nums[lo]) {
                if (nums[mid] >= nums[mid - 1]) {
                    hi = mid - 1;
                } else {
                    return nums[mid];
                }
            } else {
                if (nums[mid] == nums[hi]) {
                    return nums[lo];
                } else if (nums[mid] > nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        if (lo == hi) {
            return nums[lo];
        }

        return nums[lo] < nums[lo + 1] ? nums[lo] : nums[lo + 1];
    }

    public static void main(String[] args) {
        A154_Find_Minimum_in_Rotated_Sorted_Array_II solution = new A154_Find_Minimum_in_Rotated_Sorted_Array_II();
        int[] a = {1, 3, 3};
        System.out.println(solution.findMin(a));
    }
}
