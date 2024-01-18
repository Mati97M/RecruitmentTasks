package dev.mati.tasks.LeetCode.DynamProgramming1D;

import java.util.HashMap;

public class CoinChange {
    private HashMap<Integer, Integer> cache = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        int res = genMinNumber(coins, amount, 0);
        return  (res > amount) ? -1: res;
    }
    private int genMinNumber(int[] arr, int target, int total) {
        if(cache.containsKey(total))
            return cache.get(total);

        if(total > target) {
            cache.put(total, target + 1);
            return target + 1;
        }

        if(total == target) {
            cache.put(total, 0);
            return 0;
        }

        int min = target + 1;
        for(int c: arr) {
            if(c > target)
                continue;
            int res = genMinNumber(arr, target, total + c);
            min = Integer.min(min, res);
        }
        cache.put(total, 1 + min);
        return 1 + min;
    }
}
