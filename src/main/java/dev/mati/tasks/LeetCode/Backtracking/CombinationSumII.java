package dev.mati.tasks.LeetCode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {
    private LinkedList<List<Integer>> cs = new LinkedList<List<Integer>>();
    private int target;

    public static void main(String[] args) {
        CombinationSumII cs = new CombinationSumII();
        System.out.println(cs.combinationSum2(new int[] {10,1,2,7,6,1,5}, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target = target;
        Arrays.sort(candidates);
        generateCombinations(candidates, new LinkedList<Integer>(), 0, 0);
        return cs;
    }
    private void generateCombinations(int[] arr, LinkedList<Integer> c, int sum, int start) {
        if(sum == target) {
            cs.addLast(new ArrayList<>(c));
            return;
        }
        int i = start;
        if(i >= arr.length || sum > target)
            return;

        c.addLast(arr[i]);
        generateCombinations(arr, c, sum + arr[i], i + 1);
        c.removeLast();
        while(i + 1 < arr.length && arr[i + 1] == arr[i])
            i++;
        if(sum + arr[i] <= target)
            generateCombinations(arr, c, sum, i + 1);

    }
}
