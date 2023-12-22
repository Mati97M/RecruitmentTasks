package dev.mati.tasks.LeetCode.AdvancedGraps;

import java.util.PriorityQueue;

public class SwimRisingWater {
    public static void main(String[] args) {
        int[][] grid = {
                        {0,1,2,3,4},
                        {24,23,22,21,5},
                        {12,13,14,15,16},
                        {11,17,18,19,20},
                        {10,9,8,7,6}
        };
        System.out.println(new SwimRisingWater().swimInWater(grid));
    }
    public int swimInWater(int[][] grid) {
        int length = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a1, a2) -> Integer.compare(grid[a1[0]][a1[1]], grid[a2[0]][a2[1]])
        );
        int[][] dirs = {{-1,0}, {0,-1}, {0,1}, {1,0}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int time = 0;
        pq.offer(new int[]{0,0});
        while(!pq.isEmpty() && !visited[length - 1][length - 1]) {
            int size = pq.size();
            while(size-- > 0) {
                int[] curr = pq.poll();
                while(grid[curr[0]][curr[1]] > time) {
                    time++;
                }
                visited[curr[0]][curr[1]] = true;
                if(visited[length - 1][length - 1]) {
                    return time;
                }
                for(int[] n: dirs) {
                    int nr = n[0] + curr[0];
                    int nc = n[1] + curr[1];
                    if(nr >= grid.length || nc >= grid[0].length ||
                            nr < 0 || nc < 0 || visited[nr][nc]) {
                        continue;
                    }
                    pq.offer(new int[] {nr, nc});
                }

            }
        }
        return time;
    }
}
