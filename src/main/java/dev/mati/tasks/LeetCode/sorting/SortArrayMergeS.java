package dev.mati.tasks.LeetCode.sorting;

import java.util.Arrays;

public class SortArrayMergeS {
    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        System.out.println(Arrays.toString(sortArray(nums)));
    }
    public static int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    private static void mergeSort(int[] arr, int s, int e) {
        if(s == e)
            return;

        int m = (s + e) / 2;
        mergeSort(arr, s, m);
        mergeSort(arr, m + 1, e);

        merge(arr, s, m, e);
    }
    private static void merge(int[] arr, int l, int m, int r) {

        int aLength = m - l + 1;
        int bLength = r - m;

        int[] A = new int[aLength];
        for(int i = 0; i < aLength; i++) {
            A[i] = arr[i + l];
        }
        int[] B = new int[bLength];
        for(int i = 0; i < bLength; i++) {
            B[i] = arr[i + m + 1];
        }

        int a = 0;
        int b = 0;
        int i = l;

        while(a < A.length && b < B.length) {
            if(A[a] <= B[b]) {
                arr[i] = A[a++];
            } else {
                arr[i] = B[b++];
            }
            i++;
        }
        while(a < A.length) {
            arr[i++] = A[a++];
        }
        while(b < B.length) {
            arr[i++] = B[b++];
        }
    }
}
