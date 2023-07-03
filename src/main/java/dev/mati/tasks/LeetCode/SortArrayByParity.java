package dev.mati.tasks.LeetCode;

import java.util.Arrays;

public class SortArrayByParity {
    public static void main(String[] args) {
        int[] arr = new int[] {0,2};
        System.out.println("" + Arrays.toString(arr) + " --> " +  Arrays.toString(solution(arr)));
    }
    public static int[] solution(int[] nums) {
        if (nums == null)
            return null;

        int left = 0;
        int rigth = nums.length - 1;

        while(rigth > left) {
            if(nums[left] %2 != 0) {
                while(nums[rigth] %2 != 0) {
                    rigth--;
                    if(rigth < left)
                        return nums;
                }
                int temp = nums[left];
                nums[left] = nums[rigth];
                nums[rigth] = temp;
                left++;
                rigth--;
            } else {
                left++;
            }
        }

        return nums;
    }
}
