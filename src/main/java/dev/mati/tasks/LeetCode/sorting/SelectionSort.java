package dev.mati.tasks.LeetCode.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    private static void sort(int arr[]) {
        //selection sort, ascending
        for(int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for(int j = minIdx + 1; j < arr.length; j++) {
                if(arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            if(arr[i] > arr[minIdx]) {
                int tmp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = tmp;
            }
        }
    }
}
