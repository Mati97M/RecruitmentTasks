package dev.mati.tasks.LeetCode;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
    public static int[] productExceptSelf(int[] nums) {
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
    /*public static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int[] prefixes = new int[nums.length];
        int[] postfixes = new int[nums.length];

        prefixes[0] = 1;
        postfixes[postfixes.length - 1] = 1;
        int product = 1;

        for (int i = 1; i < prefixes.length; i++) {
            product *= nums[i - 1];
            prefixes[i] = product;
        }
        product = 1;
        for (int i = postfixes.length - 2; i >= 0; i--) {
            product *= nums[i + 1];
            postfixes[i] = product;
        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = prefixes[i] * postfixes[i];
        }
        return answer;
    }*/
}
