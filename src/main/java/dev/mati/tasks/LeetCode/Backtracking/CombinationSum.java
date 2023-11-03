package dev.mati.tasks.LeetCode.Backtracking;

import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    private int[] arr;
    private int target = 0;
    private LinkedList<List<Integer>> combinations = new LinkedList<>();

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] candidates = {2,3,5,8};
        int target = 8;
        System.out.println(cs.combinationSum(candidates,target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.arr = candidates;
        this.target = target;
        generateCombinations(new LinkedList<Integer>(), 0, 0);
        return combinations;
    }
    private void generateCombinations(LinkedList<Integer> combination, int i, int currSum) {
        if(i == arr.length || currSum > target)
            return;
        if(currSum == target) {
            combinations.add(List.copyOf(combination));
            return;
        }
        combination.addLast(arr[i]);
        generateCombinations(combination, i, currSum + arr[i]);

        combination.removeLast();
        generateCombinations(combination, i + 1, currSum);

    }
}
