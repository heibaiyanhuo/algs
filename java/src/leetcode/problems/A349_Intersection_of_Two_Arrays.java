package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A349_Intersection_of_Two_Arrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]) {
                int tmp = nums1[p1];
                result.add(tmp);
                p1++;
                p2++;
                while (p1 < nums1.length && nums1[p1] == tmp) {
                    p1++;
                };
                while (p2 < nums2.length && nums2[p2] == tmp) {
                    p2++;
                }
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }
        int[] ret = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ret[i] = result.get(i);
        }
        return ret;
    }
}
