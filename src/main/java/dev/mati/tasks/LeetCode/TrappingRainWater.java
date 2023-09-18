package dev.mati.tasks.LeetCode;

public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }
    public static int trap(int[] height) {
        int trappedWater = 0;
        int start = 0;
        int end = height.length - 1;
        int leftBank = height[start];
        int rightBank = height[end];
        int trapped = 0;
        while(start < end) {
            if(leftBank <= rightBank) {
                start++;
                trapped = leftBank - height[start];
                leftBank = Math.max(leftBank,height[start]);

            } else {
                end--;
                trapped = rightBank - height[end];
                rightBank = Math.max(rightBank,height[end]);
            }
            if(trapped > 0)
                trappedWater += trapped;
        }

        return  trappedWater;
    }
    public static int trap2(int[] height) {
        int trappedWater = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int lMax = 0;
        for (int i = 0; i < leftMax.length; i++) {
            leftMax[i] = lMax;
            lMax = Math.max(lMax,height[i]);
        }
        int rMax = 0;
        for (int i = leftMax.length - 1; i >= 0 ; i--) {
            rightMax[i] = rMax;
            rMax = Math.max(rMax,height[i]);
        }

        for(int i = 0; i < height.length; i++) {
            int trapped = Math.min(leftMax[i],rightMax[i]) - height[i];
            if(trapped > 0)
                trappedWater += trapped;
        }
        return  trappedWater;
    }

}
