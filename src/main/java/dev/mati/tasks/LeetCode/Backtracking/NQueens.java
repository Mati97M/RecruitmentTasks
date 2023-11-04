package dev.mati.tasks.LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
    private LinkedList<List<String>> boards = new LinkedList<List<String>>();
    private int n;
    private HashSet<Integer> colsTaken = new HashSet<>();
    private HashSet<Integer> posDiag = new HashSet<>();
    private HashSet<Integer> negDiag = new HashSet<>();
    private char[][] board;

    public static void main(String[] args) {
        System.out.println(new NQueens().solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.board = getPlainBoard();
        generateBoards(new ArrayList<String>(n), 0);
        return boards;
    }
    private void generateBoards(ArrayList<String> b, int r) {
        if(r == n && b.size() == n) {
            boards.add(new ArrayList<>(b));
            return;
        }
        for(int row = r; row < n; row++) {
            for(int col = 0; col < n; col++) {
                if(!colsTaken.contains(col)
                        && !posDiag.contains(row - col)
                        && !negDiag.contains(row + col)
                ) {
                    colsTaken.add(col);
                    posDiag.add(row - col);
                    negDiag.add(row + col);
                    board[row][col] = 'Q';
                    b.add(new String(board[row]));
                    generateBoards(b, row + 1);

                    b.remove(b.size() - 1);
                    colsTaken.remove(col);
                    posDiag.remove(row - col);
                    negDiag.remove(row + col);
                    board[row][col] = '.';
                }
            }

        }
    }
    private char[][] getPlainBoard()
    {
        char[][] board = new char[n][n];
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                board[r][c] = '.';
            }
        }
        return board;
    }
}
