package dev.mati.tasks.LeetCode.Intervals;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for(int[] i: intervals) {
            if(merged.isEmpty()) {
                merged.add(i);
                continue;
            }
            if(i[0] <= merged.peekLast()[1]) {
                if(i[1] > merged.peekLast()[1]) {
                    merged.getLast()[1] = i[1];
                }
            } else {
                merged.add(i);
            }
        }
        int[][] res = new int[merged.size()][];
        int i = 0;
        for(int[] m: merged) {
            res[i++] = m;
        }
        return res;
    }
}
