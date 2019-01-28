package leetcode.problems;

import leetcode.datastructures.Interval;
import leetcode.datastructures.SweepingPoint;

import java.util.Arrays;
import java.util.Comparator;

public class A253_Meeting_Rooms_II {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int N = intervals.length;
        SweepingPoint[] points = new SweepingPoint[2 * N];
        for (int i = 0; i < intervals.length; i++) {
            points[2 * i] = new SweepingPoint(intervals[i].start, 1);
            points[2 * i + 1] = new SweepingPoint(intervals[i].end, -1);
        }
        Arrays.sort(points, Comparator.comparing((SweepingPoint p) -> p.val).thenComparing(p -> -p.label));
        int max = 0;
        int count = 0;
        for (SweepingPoint p: points) {
            count += p.label;
            max = Math.max(count, max);
        }
        return max;
    }

    public int minMeetingRooms2(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int N = intervals.length;
        int[] start = new int[N];
        int[] end = new int[N];
        for (int i = 0; i < N; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int count = 0;
        int max = 0;
        for (int i = 0, j = 0; i < N && j < N; ) {
            if (start[i] < end[j]) {
                count++;
                max = Math.max(count, max);
                i++;
            } else {
                count--;
                j++;
            }
        }
        return max;
    }
}
