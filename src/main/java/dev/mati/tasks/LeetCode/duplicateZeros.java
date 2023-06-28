package dev.mati.tasks.LeetCode;

import java.util.Arrays;

public class duplicateZeros {
    public static void solution(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == 0) {
                for(int j = arr.length - 1; j > i + 1; j--) {
                    arr[j] = arr[j-1];
                }
                arr[i+1] = 0;
                i ++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        duplicateZeros.solution(new int[] {0,4,1,0,0,8,0,0,3});
    }
}
