package dev.mati.tasks.LeetCode.MathGeometry;

import java.util.LinkedList;
import java.util.List;

public class Spiral {
    private int firstCol = 0;
    private int lastCol;
    private int firstRow = 0;
    private int lastRow;
    private int[][] matrix;

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(new Spiral().spiralOrder(matrix));
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        this.matrix = matrix;
        this.lastCol = matrix[0].length - 1;
        this.lastRow = matrix.length - 1;
        LinkedList<Integer> list = new LinkedList<>();
        moveRight(0, 0, list);
        return list;
    }
    private void moveRight(int r, int c, LinkedList<Integer> list) {
        while(c <= lastCol) {
            list.add(matrix[r][c++]);
        }
        firstRow++;
        if(r < lastRow) {
            moveDown(r + 1, c - 1, list);
        }
    }

    private void moveDown(int r, int c, LinkedList<Integer> list) {
        while(r <= lastRow) {
            list.add(matrix[r++][c]);
        }
        lastCol--;
        if(c > firstCol) {
            moveLeft(r - 1, c - 1, list);
        }
    }

    private void moveLeft(int r, int c, LinkedList<Integer> list) {
        while(c >= firstCol) {
            list.add(matrix[r][c--]);
        }
        lastRow--;
        if(r > firstRow) {
            moveUp(r - 1, c + 1, list);
        }
    }

    private void moveUp(int r, int c, LinkedList<Integer> list) {
        while(r >= firstRow) {
            list.add(matrix[r--][c]);
        }
        firstCol++;
        if(c < lastCol) {
            moveRight(r + 1,c + 1, list);
        }
    }
}
