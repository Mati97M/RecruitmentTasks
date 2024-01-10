package dev.mati.tasks.LeetCode.Intervals;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(new NonOverlappingIntervals().eraseOverlapIntervals(intervals));
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int prevEnd = intervals[0][1];
        int res = 0;
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= prevEnd) {
                prevEnd = intervals[i][1];
            }
            else {
                if(prevEnd > intervals[i][1]) {
                    prevEnd = intervals[i][1];
                }
                res++;
            }
        }
        return res;
    }
}

