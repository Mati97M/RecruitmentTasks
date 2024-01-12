package dev.mati.tasks.LeetCode.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MeetingScheduleMinDays {
    public static void main(String[] args) {
        System.out.println(new MeetingScheduleMinDays().minMeetingRooms(new ArrayList<>(List.of(
                new Interval(0,10), new Interval(10,20), new Interval(20,30), new Interval(30,40),
                new Interval(40,50), new Interval(50,60),new Interval(60,70), new Interval(70,80),
                new Interval(80,90), new Interval(90,100), new Interval(0,100), new Interval(10,90),
                new Interval(20,80), new Interval(30,70), new Interval(40,60), new Interval(50,50)))
        ));
    }
    public int minMeetingRooms(List<Interval> intervals) {  //O(nlogn) in time  O(n) in space
        int[] starts = new int[intervals.size()];
        int[] ends = new int[intervals.size()];
        int maxRooms = 0;
        int i = 0;
        for(Interval itrv: intervals) {
            starts[i] = itrv.start;
            ends[i] = itrv.end;
            i++;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int s = 0;
        int e = 0;
        int currRooms = 0;
        while(s < starts.length && e < ends.length) {
            if(starts[s] < ends[e]) {
                maxRooms = Integer.max(maxRooms, ++currRooms);
                s++;
            } else {
                currRooms--;
                e++;
            }
        }
        return maxRooms;
    }
    public int minMeetingRoomsSlow(List<Interval> intervals) {  //O(n^2) in time  O(n) in space
        Collections.sort(intervals, (i1, i2) ->
                Integer.compare(i1.start, i2.start)
        );
        ArrayList<Integer> ends = new ArrayList<>();
        for(Interval i: intervals) {
            if(i.start == i.end) {
                continue;
            }
            if(ends.isEmpty()) {
                ends.add(i.end);
                continue;
            }
            int e = 0;
            while(e < ends.size()) {
                if(i.start >= ends.get(e)) {
                    ends.set(e, i.end);
                    break;
                }
                e++;
            }
            if(e == ends.size()) {
                ends.add(i.end);
            }
        }
        return ends.size();
    }
}
