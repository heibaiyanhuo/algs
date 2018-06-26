package leetcode.problems;

public class A275_H_Index_II {
    private int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int N = citations.length;
        int lo = 0, hi = N;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            int idx = N - mid;
            int n = Math.min(citations[idx], N);
            if (n >= mid) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        int n = Math.min(N, hi > 0 ? citations[N - hi] : 0);
        if (n >= hi) {
            return hi;
        }
        n = Math.min(N, lo > 0 ? citations[N - lo] : 0);
        if (n >= lo) {
            return lo;
        }
        return 0;
    }


    public static void main(String[] args) {
        A275_H_Index_II solution = new A275_H_Index_II();
        int[] a = {0, 0, 4};
        System.out.println(solution.hIndex(a));
    }
}
