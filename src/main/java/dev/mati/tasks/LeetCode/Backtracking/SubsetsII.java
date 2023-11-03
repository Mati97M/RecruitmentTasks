package dev.mati.tasks.LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsII {
    private LinkedList<List<Integer>> subsets = new LinkedList<List<Integer>>();

    public static void main(String[] args) {
        SubsetsII s2 = new SubsetsII();
        System.out.println(s2.subsetsWithDup(new int[] {1, 2, 3, 4}));
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        generateSubsets(nums, new LinkedList<Integer>(), 0);
        return subsets;
    }
    private void generateSubsets(int[] nums, LinkedList<Integer> subset, int i) {
        if(i == nums.length) {
            subsets.add(new ArrayList<Integer>(subset));
            return;
        }
        subset.addLast(nums[i]);
        generateSubsets(nums, subset, i + 1);
        subset.removeLast();

        while(i + 1 < nums.length && nums[i + 1] == nums[i])
            i++;
        generateSubsets(nums, subset, i + 1);

    }
}
