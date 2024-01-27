package dev.mati.tasks.LeetCode.DynamProgramming1D;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int prefix = 1;
        int suffix = 1;

        for(int i = 0; i < nums.length; i++) {
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;

            prefix *= nums[i];
            maxProduct = Integer.max(maxProduct, prefix);
            suffix *= nums[nums.length - 1 - i];
            maxProduct = Integer.max(maxProduct, suffix);
        }
        return maxProduct;
    }
}
