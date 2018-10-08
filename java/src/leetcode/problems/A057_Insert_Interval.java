package leetcode.problems;

import leetcode.datastructures.Interval;

import java.util.ArrayList;
import java.util.List;

public class A057_Insert_Interval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            res.add(intervals.get(i++));
        }
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }
        res.add(newInterval);
        while (i < intervals.size()) {
            res.add(intervals.get(i++));
        }
        return res;
//        int i = 0;
//        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
//            i++;
//        }
//        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
//            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
//            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
//            intervals.remove(i);
//        }
//        intervals.add(i, newInterval);
//
//        return intervals;
    }
}
