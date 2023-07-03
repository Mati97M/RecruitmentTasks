package dev.mati.tasks.LeetCode;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] arr = new int[] {4,5};
        int k = solution1(arr ,5);
        Arrays.sort(arr,0,k);
        System.out.println(Arrays.toString(Arrays.stream(arr)
                .limit(k)
                .toArray()));

        arr = new int[] {0,1,2,2,3,0,4,2};
        k = solution2(arr ,2);
        Arrays.sort(arr,0,k);
        System.out.println(Arrays.toString(Arrays.stream(arr)
                .limit(k)
                .toArray()));
    }
    public static int solution2(int[] nums, int val) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int read = 0;
        int write = 0;
        while(read < nums.length) {
            if(nums[read] != val) {
                nums[write] = nums[read];
                write++;
                read++;
            } else {
                read++;
            }
        }
        return write;
    }
    public static int solution1(int[] nums, int val) {
        int k = nums.length;
        for(int i = 0; i < k; i++) {
            if(nums[i] == val) {
                while( k > 0 && nums[k-1] == val) {
                    k--;
                }
                if(k <= 0) {
                    break;
                }
                nums[i] = nums[k-1];
                if(k > i) {
                    k--;
                }
            }
        }
        return k;
    }
}
