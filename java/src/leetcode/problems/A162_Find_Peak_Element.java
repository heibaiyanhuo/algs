package leetcode.problems;

public class A162_Find_Peak_Element {

    public int findPeakElement(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] <= nums[hi]) {
                lo = mid;
            } else if (nums[mid] <= nums[lo]) {
                hi = mid;
            } else {
                if (nums[mid + 1] > nums[mid]) {
                    lo = mid + 1;
                } else if (nums[mid - 1] > nums[mid]) {
                    hi = mid - 1;
                } else {
                    return mid;
                }
            }
        }
        if (lo == hi) {
            return lo;
        }
        if (nums[lo] > nums[lo + 1] && (lo == 0 || nums[lo] > nums[lo - 1])) {
            return lo;
        }
        return hi;
    }


    public int findPeakElement2(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid] > nums[mid - 1]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        if (lo == hi) {
            return lo;
        }
        if (nums[lo] > nums[lo + 1] && (lo == 0 || nums[lo] > nums[lo - 1])) {
            return lo;
        }
        return hi;
    }

    public static void main(String[] args) {
        A162_Find_Peak_Element solution = new A162_Find_Peak_Element();
        int[] data = new int[]{1, 2, 3};
        System.out.println(solution.findPeakElement(data));
//        System.out.println(data[624]);
//        System.out.println(data[623]);
//        System.out.println(data[625]);
    }


}
