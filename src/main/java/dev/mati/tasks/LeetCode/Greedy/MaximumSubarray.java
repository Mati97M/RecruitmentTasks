package dev.mati.tasks.LeetCode.Greedy;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int maxSum = currSum;
        for(int i = 1; i < nums.length; i++) {
            currSum = Integer.max(0, currSum);
            currSum += nums[i];
            maxSum = Integer.max(currSum, maxSum);
        }
        return maxSum;
    }
}
