package leetcode.problems;

public class A852_Peak_Index_in_a_Mountain_Array {

    public int peakIndexInMountainArray(int[] A) {
        int lo = 0;
        int hi = A.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            }
            if (A[mid] < A[mid - 1]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        if (lo == hi) {
            return lo;
        }
        if (A[lo] > A[lo + 1] && (lo == 0 || A[lo] > A[lo - 1])) {
            return lo;
        }

        return hi;
    }
}
