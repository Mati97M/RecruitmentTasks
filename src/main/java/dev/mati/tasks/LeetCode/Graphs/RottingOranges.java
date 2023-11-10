package dev.mati.tasks.LeetCode.Graphs;

import java.util.LinkedList;

public class RottingOranges {
    boolean rotten[][];

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        RottingOranges ro = new RottingOranges();
        System.out.println(ro.orangesRotting(grid));
    }
    public int orangesRotting(int[][] grid) {
        LinkedList<int[]> q = new LinkedList<int[]>();
        int rows = grid.length;
        int cols = grid[0].length;
        rotten = new boolean[rows][cols];
        int fresh = 0;
        //get all rotten and count fresh
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == 2) {
                    rotten[r][c] = true;
                    q.offer(new int[]{r,c});
                }else if(grid[r][c] == 1)
                    fresh++;
            }
        }
        int minutes = 0;
        //BFS
        int[][] neighDir = {{0,-1}, {-1, 0}, {0, 1}, {1, 0}};
        while(!q.isEmpty() && fresh > 0) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] polled = q.poll();
                int r = polled[0];
                int c = polled[1];
                for(int[] n: neighDir) {
                    int nr = r + n[0];
                    int nc = c + n[1];
                    if(nr < 0 || nc < 0 || nr >= rows || nc >= cols
                            || rotten[nr][nc] || grid[nr][nc] == 0)
                        continue;
                    rotten[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                    fresh--;
                }
            }
            minutes++;
        }
        if(fresh > 0)
            return -1;

        return minutes;
    }
}
