package dev.mati.tasks.LeetCode.Graphs;

import java.util.LinkedList;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        NumberOfIslands noi = new NumberOfIslands();
        System.out.println(noi.numIslands(grid));
    }
    private boolean[][] visited;
    private int rows;
    private int cols;
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];

        int islandsNum = 0;
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == '1' && visited[r][c] == false) {
                    islandsNum++;
                    markWithBFS(grid, r, c);
                }
            }
        }
        return islandsNum;
    }
    private void markWithBFS(char[][] grid, int r, int c) {
        LinkedList<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c});
        visited[r][c] = true;
        int[][] neighbDir = {{0, -1}, {-1, 0}, {1, 0}, {0, 1}};

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i ++) {
                int[] curr = q.poll();
                r = curr[0]; c = curr[1];
                for(int[] n: neighbDir) {
                    if(Integer.min(n[0] + r, n[1] + c) < 0
                            || n[0] + r >= rows || n[1] + c >= cols
                            || grid[n[0] + r][n[1] + c] == '0'
                            || visited[n[0] + r][n[1] + c] == true
                    )
                        continue;
                    q.offer(new int[] {n[0] + r, n[1] + c});
                    visited[n[0] + r][n[1] + c] = true;
                }
            }
        }
    }
}
