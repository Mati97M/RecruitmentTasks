package dev.mati.tasks.LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> subsets = new ArrayList<List<Integer>>();
        generateSubsets(subsets, new LinkedList<Integer>(), nums, 0);
        return subsets;
    }
    public static void generateSubsets(ArrayList<List<Integer>> sets, LinkedList<Integer> subset, int[] nums, int i) {
        if(i == nums.length) {
            sets.add(List.copyOf(subset));
            return;
        }

        subset.push(nums[i]);
        generateSubsets(sets, subset, nums, i + 1);
        subset.pop();

        generateSubsets(sets, subset, nums, i + 1);
    }
}
