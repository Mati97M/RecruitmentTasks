package dev.mati.tasks.LeetCode.HeapPriorityQueue;

import dev.mati.tasks.LeetCode.Graphs.MatrixPrinter;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsOrigin {
    public static void main(String[] args) {
        int[][] points = {{1,3},{-2,2}};
        int k = 1;
        MatrixPrinter.print2D(new KClosestPointsOrigin().kClosest(points, k));
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {

                int x1 = ((int[]) o1)[0];
                int y1 = ((int[]) o1)[1];
                double a = Math.pow(x1, 2) + Math.pow(y1, 2);

                int x2 = ((int[]) o2)[0];
                int y2 = ((int[]) o2)[1];
                double b = Math.pow(x2, 2) + Math.pow(y2, 2);

                return Double.compare(a, b);
            }
        });
        for(int[] xy: points) {
            pq.offer(xy);
        }
        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++)
            result[i] = pq.poll();
        return result;
    }
}
