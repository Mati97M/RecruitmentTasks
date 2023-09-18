package dev.mati.tasks.LeetCode;

import java.util.Stack;

public class LargestRectangleArea {
    public static void main(String[] args) {
        Stack<int[]> continuousHeights = new Stack<int[]>();
        int[] a  = new int[2];
        a[0] = 100;
        a[1] = 50;
        int[] b = {2,3};
        continuousHeights.push(a);
        continuousHeights.forEach(array -> System.out.printf("[0]: %d\t[1]:%d\n", array[0],array[1]));
        continuousHeights.peek()[0] = 2;
        continuousHeights.forEach(array -> System.out.printf("[0]: %d\t[1]:%d\n", array[0],array[1]));

        System.out.println("solution: " + largestRectangleArea(new int[]{2,4}));
        System.out.println("solution: " + largestRectangleArea(new int[]{2,1,5,6,2,3}));
        System.out.println("solution: " + largestRectangleArea(new int[]{3,6,5,7,4,8,1,0}));

    }
    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> contStartHeights = new Stack<int[]>();

        for(int i = 0; i < heights.length; i++) {
            int start = i;
            if(!contStartHeights.isEmpty()) {
                while(!contStartHeights.isEmpty() &&
                        contStartHeights.peek()[1] > heights[i]) {
                    int[] x = contStartHeights.pop();
                    maxArea = Math.max(maxArea, (i - x[0]) * x[1] );
                    start = x[0];
                }
            }
            int[] startHeight = {start, heights[i]};
            contStartHeights.push(startHeight);
        }
        while(!contStartHeights.isEmpty()) {
            int[] x = contStartHeights.pop();
            maxArea = Math.max(maxArea, (heights.length - x[0]) * x[1] );
        }
        return maxArea;
    }
}
