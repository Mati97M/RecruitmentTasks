package dev.mati.tasks.LeetCode.Graphs;

import java.util.LinkedList;

public class MaxAreaIslands {
    private int rows;
    private int cols;
    private boolean[][] visited;

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(new MaxAreaIslands().maxAreaOfIsland(grid));
    }
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == 1 && !visited[r][c]) {
                    int area = countAreaBFS(grid, r, c);
                    maxArea = Integer.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }
    private int countAreaBFS(int[][] grid, int r, int c) {
        LinkedList<int[]> q = new LinkedList<>();
        q.offer(new int[] {r,c});
        visited[r][c] = true;
        int[][] neighDir = {{-1,0}, {0, -1}, {1,0}, {0,1}};
        int area = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            area += size;
            for(int i = 0; i < size; i++) {
                int[] polled = q.poll();
                for(int[] neigh: neighDir) {
                    int nr = neigh[0] + polled[0];
                    int nc = neigh[1] + polled[1];
                    if(nr < 0 || nc < 0
                            || nr >= rows || nc >= cols
                            || visited[nr][nc] == true
                            || grid[nr][nc] == 0)
                        continue;
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr, nc});
                }
            }
        }
        return area;
    }
}
