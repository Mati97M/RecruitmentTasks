package dev.mati.tasks.LeetCode.Intervals;

import java.io.IOException;

import static dev.mati.tasks.LeetCode.Intervals.DataLoader.getIntervals;
import static dev.mati.tasks.LeetCode.Intervals.DataLoader.getQueries;

public class MinIntervalToInclude {
    public static void main(String[] args) throws IOException {
        int[][] intervals = getIntervals("src/main/java/dev/mati/tasks/LeetCode/Intervals/intervals.txt");
        int[] queries = getQueries("src/main/java/dev/mati/tasks/LeetCode/Intervals/queries.txt");
        //System.out.println(Arrays.toString(new MinIntervalToInclude().minInterval(intervals, queries)));
    }
    public int[] minIntervalSlow(int[][] intervals, int[] queries) { //O(qi) in time
        int[] res = new int[queries.length];
        int intv = -1;
        int size = Integer.MAX_VALUE;
        int r = 0;
        for(int q: queries) {
            for(int i = 0; i < intervals.length; i++) {
                if(q >= intervals[i][0] && q <= intervals[i][1]) {
                    int currSize = intervals[i][1] - intervals[i][0] + 1;
                    if(currSize <= size) {
                        size = currSize;
                        intv = i;
                    }
                }
            }
            if(intv != -1) {
                res[r++] = size;
            } else {
                res[r++] = -1;
            }
            intv = -1;
            size = Integer.MAX_VALUE;
        }
        return res;
    }
}
