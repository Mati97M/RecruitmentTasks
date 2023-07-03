package dev.mati.tasks.LeetCode;

import java.util.Arrays;

public class SortArrayByParity {
    public static void main(String[] args) {
        int[] arr = new int[] {0,2};
        int[] arr2 = new int[] {3,1,6,4,5,8,6,7,9,0};
        System.out.println("" + Arrays.toString(arr) + " --> " +  Arrays.toString(solution(arr)));
        System.out.println("" + Arrays.toString(arr2) + " --> " +  Arrays.toString(solution(arr2)));
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
