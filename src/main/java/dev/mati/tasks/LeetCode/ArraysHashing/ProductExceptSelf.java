package dev.mati.tasks.LeetCode.ArraysHashing;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        int[] pref = new int[length];
        int[] suff = new int[length];

        int temp = 1;
        for(int i = 0; i < length; i++) {
            temp *= nums[i];
            pref[i] = temp;
        }
        temp = 1;
        for(int i = length - 1; i >= 0; i--) {
            temp *= nums[i];
            suff[i] = temp;
        }

        ans[0] = suff[1];
        ans[length - 1] = pref[length - 2];
        for(int i = 1; i < length - 1; i++) {
            ans[i] = pref[i - 1] * suff[i + 1];
        }
        return ans;
    }
    public static int[] productExceptSelfInPlace(int[] nums) {
        int[] answer = new int[nums.length];
        int product = 1;
        //prefix
        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            product *= nums[i - 1];
            answer[i] = product;
        }
        product = 1;
        //postfix and answer
        for(int i = nums.length - 2; i >= 0; i--) {
            product *= nums[i + 1];
            answer[i] *= product;
        }
        return answer;
    }
}
