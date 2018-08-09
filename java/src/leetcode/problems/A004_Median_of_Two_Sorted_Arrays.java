package leetcode.problems;

public class A004_Median_of_Two_Sorted_Arrays {
    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int L = (nums1 == null ? 0 : nums1.length) + (nums2 == null ? 0 : nums2.length);
        if ((L & 1) == 1) {
            return findKth(nums1, nums2, 0, 0, L / 2 + 1);
        }
        return (findKth(nums1, nums2, 0, 0, L / 2) + findKth(nums1, nums2, 0, 0, L / 2 + 1)) / 2.0;
    }

    private int findKth(int[] nums1, int[] nums2, int s1, int s2, int k) {
        if (nums1 == null || s1 >= nums1.length) {
            return nums2[s2 + k - 1];
        }
        if (nums2 == null || s2 >= nums2.length) {
            return nums1[s1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[s1], nums2[s2]);
        }
        int mid1 = s1 + k / 2 - 1;
        int mid2 = s2 + k / 2 - 1;
        int n1 = mid1 >= nums1.length ? Integer.MAX_VALUE : nums1[mid1];
        int n2 = mid2 >= nums2.length ? Integer.MAX_VALUE : nums2[mid2];
        if (n1 < n2) {
            return findKth(nums1, nums2, s1 + k / 2, s2, k - k / 2);
        } else {
            return findKth(nums1, nums2, s1, s2 + k / 2, k - k / 2);
        }
    }

    public static void main(String[] args) {
        A004_Median_of_Two_Sorted_Arrays solution = new A004_Median_of_Two_Sorted_Arrays();
        int[] a = {1, 2, 5, 6};
        int[] b = {2, 3};
        System.out.println(solution.findMedianSortedArrays(a, b));
//        System.out.println(solution.findKth(a, b, 0, 0, 4));
    }
}
