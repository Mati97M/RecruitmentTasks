package dev.mati.tasks.LeetCode.DynamProgramming1D;

import java.util.HashMap;

public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(44));
    }
    private HashMap<Integer, Integer> cache = new HashMap<>();
    private int ways = 0;
    private int target = 0;

    public int climbStairs(int n) {
        target = n;
        return DFSMemoization(0);
    }
    private int DFSMemoization(int total) {
        if(total > target) {
            return 0;
        }
        if(cache.containsKey(total)) {
            return cache.get(total);
        }
        if(total == target) {
            cache.put(target, 1);
            return 1;
        }
        cache.put(total, DFSMemoization(total + 1) + DFSMemoization(total + 2));
        return cache.get(total);
    }

    public int climbStairs2(int n) {
        target = n;
        DFSslow(0);
        return ways;
    }
    private void DFSslow(int total) {  //O(2^n) in time -> decision tree
        if(total > target) {
            return;
        }
        if(total == target) {
            ways++;
            return;
        }
        DFSslow(total + 1);
        DFSslow(total + 2);
    }
}
