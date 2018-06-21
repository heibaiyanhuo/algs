package leetcode.problems;

public class A081_Search_in_Rotated_Sorted_Array_II {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int lo = 0;
        int hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[lo]) {
                lo++;
                continue;
            }
            if (nums[mid] < target) {
                if (nums[mid] > nums[lo] || target < nums[lo]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                if (nums[mid] < nums[lo] || target >= nums[lo]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }

        if (nums[lo] == target) {
            return true;
        }
        if (lo + 1 < nums.length && nums[lo + 1] == target) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        A081_Search_in_Rotated_Sorted_Array_II solution = new A081_Search_in_Rotated_Sorted_Array_II();
        int[] a = {1, 2, 1};
        System.out.println(solution.search(a, 0));
    }
}
