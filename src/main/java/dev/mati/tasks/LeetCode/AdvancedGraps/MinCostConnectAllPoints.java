package dev.mati.tasks.LeetCode.AdvancedGraps;

import java.util.HashSet;
import java.util.PriorityQueue;

public class MinCostConnectAllPoints {
    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(new MinCostConnectAllPoints().minCostConnectPoints(points));
    }
    private int[][] points;
    public int minCostConnectPoints(int[][] points) {
        if(points.length <= 1)
            return 0;
        this.points = points;
        //Prim
        int minCost = 0;
        HashSet<Integer> visited = new HashSet<>(); //points indexes
        PriorityQueue<int[]> minCostE = new PriorityQueue<>( // cost, iSrc, iDist
                (a,b) -> Integer.compare(a[0], b[0])
        );

        visited.add(0);
        for(int i = 1; i < points.length; i++)
            minCostE.offer(new int[]{getCost(0, i), 0, i});

        while(!minCostE.isEmpty() && visited.size() < points.length) {
            int[] polledE = minCostE.poll();
            if(visited.contains(polledE[1]) && visited.contains(polledE[2]))
                continue;
            visited.add(polledE[2]);
            minCost += polledE[0];
            for(int i = 0; i < points.length; i++) {
                if(visited.contains(i))
                    continue;
                minCostE.offer(new int[] {getCost(polledE[2], i), polledE[2], i});
            }
        }
        return minCost;
    }
    private int getCost(int p1, int p2) {
        int x1 = points[p1][0];
        int y1 = points[p1][1];

        int x2 = points[p2][0];
        int y2 = points[p2][1];

        int x = (x1 >= x2) ? x1 - x2 : x2 - x1;
        int y = (y1 >= y2) ? y1 - y2 : y2 - y1;
        return x + y;
    }
}
