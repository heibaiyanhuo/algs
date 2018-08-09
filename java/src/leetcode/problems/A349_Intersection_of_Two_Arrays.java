package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class A349_Intersection_of_Two_Arrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
//        Set<Integer> set = IntStream.of(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set = new HashSet<>();
        for (int n: nums1) {
            set.add(n);
        }
        List<Integer> result = new ArrayList<>();


        for (int n: nums2) {
            if (set.contains(n)) {
                result.add(n);
                set.remove(n);
            }
        }
        int[] ret = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ret[i] = result.get(i);
        }
//        return result.stream().mapToInt(x -> x).toArray();
        return ret;
    }
}
