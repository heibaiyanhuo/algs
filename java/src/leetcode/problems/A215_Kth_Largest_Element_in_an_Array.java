package leetcode.problems;

public class A215_Kth_Largest_Element_in_an_Array {

    public int findKthLargest(int[] nums, int k) {
        k--;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int p = (int) Math.round(Math.random() * (end - start)) + start;
            p = partition(nums, start, end, p);
            if (p == k) {
                return nums[p];
            }
            if (p > k) {
                end = p - 1;
            } else {
                start = p + 1;
            }
        }
        return nums[start];
    }

    private int partition(int[] nums, int start, int end, int p) {
        int pivot = nums[p];
        swap(nums, p, end);
        int j = start;
        for (int i = start; i < end; i++) {
            if (nums[i] > pivot) {
                swap(nums, i, j);
                j++;
            }
        }
        swap(nums, j, end);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
