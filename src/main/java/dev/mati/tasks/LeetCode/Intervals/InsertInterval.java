package dev.mati.tasks.LeetCode.Intervals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import static dev.mati.tasks.LeetCode.Graphs.MatrixPrinter.print2D;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        print2D(new InsertInterval().insert(intervals, newInterval));
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        PriorityQueue<int[]> sorted = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0])
        );
        sorted.offer(newInterval);
        for(int[] i: intervals) {
            sorted.offer(i);
        }
        LinkedList<int[]> merged = new LinkedList<>();
        while(!sorted.isEmpty()) {
            int[] curr = sorted.poll();
            if(merged.isEmpty()) {
                merged.add(curr);
                continue;
            }
            if(curr[0] <= merged.peekLast()[1]) {
                if(curr[1] > merged.peekLast()[1]) {
                    merged.getLast()[1] = curr[1];
                }
            } else {
                merged.add(curr);
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
