package leetcode.problems;

import leetcode.datastructures.Interval;

import java.util.Arrays;
import java.util.Comparator;

public class A252_Meeting_Rooms {

    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, Comparator.comparing((interval -> interval.start)));
        int end = intervals[0].end;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < end) {
                return false;
            }
            end = intervals[i].end;
        }
        return true;
    }
}
