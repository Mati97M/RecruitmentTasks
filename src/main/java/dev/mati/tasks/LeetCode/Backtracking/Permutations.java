package dev.mati.tasks.LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    private boolean[] used;

    public static void main(String[] args) {
        Permutations perms = new Permutations();
        System.out.println(perms.permute(new int[] {1,2,3}));
    }
    private LinkedList<List<Integer>> permutations;
    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        permutations = new LinkedList<List<Integer>>();
        generatePermutations(nums, new ArrayList<Integer>(nums.length));
        return permutations;
    }
    private void generatePermutations(int[] nums, ArrayList<Integer> permutation) {
        if(permutation.size() == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!used[i]) {
                permutation.add(nums[i]);
                used[i] = true;
                generatePermutations(nums, permutation);
                used[i] = false;
                permutation.remove(permutation.size() - 1);

            }
        }
    }
}
