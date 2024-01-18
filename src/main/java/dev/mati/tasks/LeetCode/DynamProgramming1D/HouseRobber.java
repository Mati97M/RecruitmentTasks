package dev.mati.tasks.LeetCode.DynamProgramming1D;

import java.util.HashMap;

public class HouseRobber {  //TO DO: Tabulation and space complexity reduction
    private int[] arr;
    int max = 0;
    HashMap<Integer, Integer> cache = new HashMap<>();
    public static void main(String[] args) {
        int[] arr = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        System.out.println(new HouseRobber().robWithMemoization(arr));
    }
    ///////////////////////////////////////////////////
    public int robWithMemoization(int[] nums) {
        return maxFrom0ToMemo(nums.length - 1, nums);
    }
    private int maxFrom0ToMemo(int i, int[] arr) {
        if(cache.containsKey(i)) {
            return cache.get(i);
        }
        if(i == 0) {
            cache.put(i, arr[i]);
            return arr[i];
        }
        if(i < 0) {
            return 0;
        }
        int pick = arr[i] + maxFrom0ToMemo(i - 2, arr);
        int notPick = maxFrom0ToMemo(i - 1, arr);
        int max = Integer.max(pick, notPick);
        cache.put(i, max);
        return max;
    }
    ///////////////////////////////////////////////////
    public int robSlow(int[] nums) {
        return maxFrom0ToSlow(nums.length - 1, nums);
    }
    private int maxFrom0ToSlow(int i, int[] arr) {
        if(i == 0) {
            return arr[i];
        }
        if(i < 0) {
            return 0;
        }
        int pick = arr[i] + maxFrom0ToSlow(i - 2, arr);
        int notPick = maxFrom0ToSlow(i - 1, arr);

        return Integer.max(pick, notPick);
    }

    public int robGenMaxSumSlow(int[] nums) {
        arr = nums;
        genMaxSum(0, 0);
        return max;
    }
    private void genMaxSum(int i, int total) {
        if(i >= arr.length) {
            max = Integer.max(max, total);
            return;
        }
        total += arr[i];
        genMaxSum(i + 2, total);
        total -= arr[i];
        genMaxSum(i + 1, total);

    }
}
