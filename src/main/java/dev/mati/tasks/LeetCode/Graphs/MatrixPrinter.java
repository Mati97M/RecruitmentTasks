package dev.mati.tasks.LeetCode.Graphs;

import java.util.Arrays;

public class MatrixPrinter {
    public static void print2D(char[][] arr2D) {
        for (char[] row: arr2D) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void print2D(int[][] arr2D) {
        for (int[] row: arr2D) {
            System.out.println(Arrays.toString(row));
        }
    }
}
