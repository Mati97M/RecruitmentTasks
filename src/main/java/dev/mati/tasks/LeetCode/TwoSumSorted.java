package dev.mati.tasks.LeetCode;

import java.util.Arrays;

public class TwoSumSorted {
    public static void main(String[] args) {
        int[] numbers = {-3, -1, 7, 8, 9};
        int target = 7;
        System.out.println(Arrays.toString(twoSum(numbers,target)));
    }
    public static int[] twoSum(int[] numbers, int target) {
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
}
