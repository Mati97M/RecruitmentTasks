package dev.mati.tasks.LeetCode;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] heigths = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(heigths));
    }
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int start = 0;
        int end = height.length - 1;
        while(start < end) {
            int realHeight = Math.min(height[end], height[start]);
            int width = end - start;
            maxArea = Math.max(maxArea, realHeight * width);
            if (height[start] < height[end])
                start++;
            else
                end--;
        }
        return maxArea;
    }
    public static int maxAreaBF(int[] height) {
        int maxArea = 0;
        for(int start = 0; start < height.length - 1; start++) {
            for (int end = start + 1; end < height.length; end++) {
                int realHeight = Math.min(height[end], height[start]);
                int width = end - start;
                maxArea = Math.max(maxArea, realHeight * width);
            }
        }
        return maxArea;
    }
}
