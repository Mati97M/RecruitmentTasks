package dev.mati.tasks.LeetCode.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        InsertionSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void sort(int[] arr) {
        //insertion sort
        for(int i = 1; i < arr.length; i++) {
            int j = i - 1;
            while(j >= 0 && arr[j] > arr[j + 1]) {
                int tmp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = tmp;
                j--;
            }
        }
    }
}
