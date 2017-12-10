/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 */


const minMeetingRooms = (intervals) => {
    let start = [];
    let end = [];
    for (let i = 0; i < intervals.length; i++) {
        start.push(intervals[i].start);
        end.push(intervals[i].end);
    }

    start.sort((a, b) => a - b);
    end.sort((a, b) => a - b);
    let ep = 0;
    let rooms = 0;
    for (let i = 1; i < start.length; i++) {
        if (start[i] < end[ep]) {
            rooms++
        } else {
            ep++;
        }
    }
    return rooms;
}