package dev.mati.tasks.LeetCode.Graphs;

import java.util.LinkedList;

public class WallsGates {
    public static void main(String[] args) {
        int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        WallsGates wg = new WallsGates();
        wg.wallsAndGates(rooms);
        MatrixPrinter.print2D(rooms);
    }
    public void wallsAndGates(int[][] rooms) {
        int rows = rooms.length;
        int cols = rooms[0].length;
        boolean[][] INFs = new boolean[rows][cols];
        boolean[][] visited = new boolean[rows][cols];

        LinkedList<int[]> q = new LinkedList<>();
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(rooms[r][c] == 2147483647)
                    INFs[r][c] = true;
                else if(rooms[r][c] == 0) {
                    q.offer(new int[]{r,c});
                    visited[r][c] = true;
                }
            }
        }
        int[][] nDir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        int dist = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] polled = q.poll();
                int r = polled[0];
                int c = polled[1];
                if(INFs[r][c])
                    rooms[r][c] = Integer.min(rooms[r][c], dist);
                for(int[] n: nDir) {
                    int nr = r + n[0];
                    int nc = c + n[1];
                    if(nr < 0 || nc < 0 || nr >= rows || nc >= cols
                            || visited[nr][nc] || rooms[nr][nc] == -1)
                        continue;
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
            dist++;
        }
    }
}
