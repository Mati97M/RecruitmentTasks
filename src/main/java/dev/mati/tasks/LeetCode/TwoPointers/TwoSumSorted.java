package dev.mati.tasks.LeetCode.TwoPointers;

import java.util.Arrays;

public class TwoSumSorted {
    public static void main(String[] args) {
        int[] numbers = {-3, -1, 7, 8, 9};
        int target = 7;
        System.out.println(Arrays.toString(twoSum(numbers,target)));
    }
    public static int[] twoSum(int[] numbers, int target) { //O(n) in time, O(1) in space
        int start = 0;
        int end = numbers.length - 1;

        while(start < end) {
            int numberWeNeed = target - numbers[end];
            if(numberWeNeed == numbers[start])
                return new int[]{start + 1, end + 1};   //incrementation request specified by the task
            else if(numberWeNeed > numbers[start]) {
                start++;
            } else
                end--;
        }

        return null;
    }
    //brute force
    public static int[] twoSumBF(int[] numbers, int target) {   //O(n^2) in time, O(1) in space
        int[] res = new int[2];
        for(int l = 0; l < numbers.length; l++) {
            int needed = target - numbers[l];
            for(int r = l + 1; r < numbers.length; r++) {
                if(needed == numbers[r]) {
                    res[0] = l + 1;
                    res[1] = r + 1;
                    return res;
                }
                if(numbers[r] > needed)
                    break;

            }
        }
        return res;
    }
}
