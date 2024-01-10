package dev.mati.tasks.LeetCode.Intervals;

import java.util.Collections;
import java.util.List;

public class MeetingSchedule {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() < 2)
            return true;
        Collections.sort(intervals,
                (i1, i2) -> Integer.compare(i1.start, i2.start));
        int prevEnd = -1;
        for(Interval i: intervals) {
            if(i.start < prevEnd) {
                return false;
            }
            prevEnd = i.end;
        }
        return true;
    }
}

