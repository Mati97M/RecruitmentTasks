package dev.mati.tasks.LeetCode;

import java.util.Arrays;

public class ReplaceElements {
    public static void main(String[] args) {
        System.out.println("[17,18,5,4,6,1] --> " + Arrays.toString(solution(new int[]{17,18,5,4,6,1})));
        //expected: [18,6,6,6,1,-1]
    }
    public static int[] solution(int[] arr) {
        if(arr.length == 0 || arr == null) {
            return arr;
        }
        int max = arr[arr.length - 1];
        for(int i = arr.length - 1; i >= 0; i-- ) {
            int temp = arr[i];
            arr[i] = max;
            if(temp > max) {
                max = temp;
            }
        }
        arr[arr.length - 1] = -1;
        return arr;
    }
}
