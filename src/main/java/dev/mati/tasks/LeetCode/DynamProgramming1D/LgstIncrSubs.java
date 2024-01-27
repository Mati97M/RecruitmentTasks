package dev.mati.tasks.LeetCode.DynamProgramming1D;

import java.util.Arrays;
import java.util.LinkedList;

public class LgstIncrSubs {

    public int lengthOfLIS(int[] nums) {
        int[] lengths = new int[nums.length];
        Arrays.fill(lengths, 1);
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                int prev = nums[j];
                if(prev < nums[i]) {
                    lengths[i] = Integer.max(lengths[i], lengths[j] + 1 );
                }
            }
        }
        return Arrays.stream(lengths).max().getAsInt();
    }
    public int lengthOfLISGen(int[] nums) {
        return genSubs(nums, 0, new LinkedList<>());
    }
    private int genSubs(int[] arr, int i, LinkedList<Integer> seq) {
        if(i >= arr.length) {
            return seq.size();
        }
        int picked = 0;
        if(seq.isEmpty() || seq.getLast() < arr[i]) {
            seq.add(arr[i]);
            picked = genSubs(arr, i + 1, seq);
            seq.removeLast();
        }
        int nPicked = genSubs(arr, i + 1, seq);

        return Integer.max(nPicked, picked);
    }
}
