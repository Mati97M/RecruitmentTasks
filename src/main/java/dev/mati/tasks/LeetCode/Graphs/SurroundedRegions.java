package dev.mati.tasks.LeetCode.Graphs;

import java.util.LinkedList;

public class SurroundedRegions {
    private boolean[][] visited;
    int rows;
    int cols;

    public static void main(String[] args) {
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}};

        SurroundedRegions sr = new SurroundedRegions();
        sr.solve(board);
        MatrixPrinter.print2D(board);
    }
    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];
        //top & bottom
        for(int r: new int[]{0,rows - 1} ) {
            for(int c = 0; c < cols; c++) {
                excludeBorderConnBFS(board, r, c);
            }
        }
        //left && right
        for(int c: new int[]{0, cols - 1}) {
            for(int r = 0; r < rows; r++) {
                excludeBorderConnBFS(board, r, c);
            }
        }
        for(int r = 1; r < rows; r++) {
            for(int c = 1; c < cols; c++) {
                if(board[r][c] == 'O' && !visited[r][c])
                    board[r][c] = 'X';
            }
        }

    }
    private void excludeBorderConnBFS(char[][] board, int r, int c) {
        if(board[r][c] == 'X' || visited[r][c])
            return;
        LinkedList<int[]> q = new LinkedList<>();
        q.offer(new int[]{r,c});
        visited[r][c] = true;
        int[][] neighDir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] polled = q.poll();
                r = polled[0];
                c = polled[1];
                for(int[] n: neighDir) {
                    int nr = n[0] + r;
                    int nc = n[1] + c;
                    if(nr >= rows || nc >= cols || nr < 0 || nc < 0
                            || visited[nr][nc] || board[nr][nc] == 'X')
                        continue;
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }

        }

    }
}
