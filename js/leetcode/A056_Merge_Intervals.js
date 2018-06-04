/**
Given a collection of intervals, merge all overlapping intervals.
 */

const Interval = require('./datastructure').Interval

var merge = function(intervals) {
    if (intervals.length === 0) return [];
    let result = [];
    intervals.sort((a, b) => a.start - b.start);
    let start = intervals[0].start, end = intervals[0].end;
    for (let i = 1; i < intervals.length; i++) {
        if (end >= intervals[i].start) {
            end = Math.max(intervals[i].end, end);
        } else {
            result.push([start, end]);
            start = intervals[i].start;
            end = intervals[i].end;
        }
    }
    result.push([start, end]);

    return result;
};

// let intervals = [new Interval(1, 3), new Interval(1, 3), new Interval(1, 3), new Interval(1, 3)]

