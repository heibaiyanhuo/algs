package leetcode.problems;

import leetcode.datastructures.Interval;
import leetcode.datastructures.SweepingPoint;

import java.util.*;

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

    private List<Interval> merge2(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return intervals;
        }
        intervals.sort((x, y) -> x.start - y.start);
        List<Interval> result = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval i: intervals) {
            if (i.start <= end) {
                end = Math.max(end, i.end);
            } else {
                result.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }

    private List<Interval> merge3(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return intervals;
        }
        List<SweepingPoint> points = new ArrayList<>();
        for (Interval interval: intervals) {
            points.add(new SweepingPoint(interval.start, 1));
            points.add(new SweepingPoint(interval.end, -1));
        }
        points.sort(Comparator.comparing((SweepingPoint p) -> p.val).thenComparing(p -> -p.label));
//        points.sort((p1, p2) -> {
//            if (p1.val == p2.val) {
//                return p2.label - p1.label;
//            }
//            return p1.val - p2.val;
//        });
        List<Interval> res = new ArrayList<>();
        int count = 0;
        int start = 0;
        for (SweepingPoint p: points) {
            if (count == 0) {
                start = p.val;
            }
            count += p.label;
            if (count == 0) {
                res.add(new Interval(start, p.val));
            }
        }
        return res;
    }
}
