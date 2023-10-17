package dev.mati.tasks.LeetCode.ArraysHashing;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        Map<Integer,Integer> valsIndices = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            indices[0] = i;
            int missing = target - nums[i];
            if(valsIndices.get(missing) != null) {
                indices[1] = valsIndices.get(missing);
                break;
            }
            valsIndices.put(nums[i],i);
        }
        return indices;
    }
}
