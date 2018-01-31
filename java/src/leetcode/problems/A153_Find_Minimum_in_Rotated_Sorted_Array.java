package leetcode.problems;

public class A153_Find_Minimum_in_Rotated_Sorted_Array {


    private int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;

        int target = nums[nums.length - 1];

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[start] < target) {
            return nums[start];
        } else {
            return nums[end];
        }
    }

    public static void main(String[] args) {
        A153_Find_Minimum_in_Rotated_Sorted_Array s = new A153_Find_Minimum_in_Rotated_Sorted_Array();
        System.out.println(s.findMin(new int[]{4,5,1,2,3}));
    }
}
