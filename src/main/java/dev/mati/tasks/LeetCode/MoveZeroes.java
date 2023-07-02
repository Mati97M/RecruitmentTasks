package dev.mati.tasks.LeetCode;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,3,12};
        System.out.print(Arrays.toString(arr) + " --> "); //expected: [1,3,12,0,0]
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0)
            return;

        int zeros = 0;
        int writeIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[writeIndex] = nums[i];
                writeIndex++;
            } else {
                zeros++;
            }
        }
        for(int i = nums.length - 1; zeros > 0; zeros--) {
            nums[i--] = 0;
        }
    }
}
