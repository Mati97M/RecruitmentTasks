package dev.mati.tasks.LeetCode;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,1,1,2,2,3,3,4};
        int k = removeDuplicates(arr);
        System.out.println("[0,0,1,1,1,2,2,3,3,4] --> " + Arrays.toString(Arrays.copyOf(arr,k)));
    }
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;

        int k = 1; //number of unique elements
        int prevVal = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != prevVal) {
                nums[k] = nums[i];
                prevVal = nums[i];
                k++;
            }
        }
        return k;
    }
}
