package leetcode.problems;

import leetcode.datastructures.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A056_Merge_Intervals {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return intervals;
        }
        int n = intervals.size();
        int[] start_arr = new int[n];
        int[] end_arr = new int[n];

        for (int i = 0; i < n; i++) {
            start_arr[i] = intervals.get(i).start;
            end_arr[i] = intervals.get(i).end;
        }

        Arrays.sort(start_arr);
        Arrays.sort(end_arr);
        List<Interval> ret = new ArrayList<>();
        int startIdx = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || end_arr[i] < start_arr[i + 1]) {
                ret.add(new Interval(start_arr[startIdx], end_arr[i]));
                startIdx++;
            }

        }
        return ret;
    }
}
