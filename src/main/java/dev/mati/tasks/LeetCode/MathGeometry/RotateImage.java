package dev.mati.tasks.LeetCode.MathGeometry;

import static dev.mati.tasks.LeetCode.Graphs.MatrixPrinter.print2D;

public class RotateImage {
    public static void main(String[] args) {
        int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
        print2D(m);
        RotateImage rtImg = new RotateImage();
        rtImg.rotate(m);
        System.out.println();
        print2D(m);
    }
    public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = i; j < matrix[0].length; j++){
//                System.out.println("" + i + " " + j);
                swap2D(i, j, matrix);
            }
        }
         for(int i = 0; i < matrix.length; i++) {
             for(int j = 0; j < matrix[0].length / 2; j++) {
                 swap(j, matrix.length - 1 - j, matrix[i]);
             }
         }

    }
    private void swap(int a, int b, int[] arr) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    private void swap2D(int i, int j, int[][] arr) {
        int tmp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = tmp;
    }
}
