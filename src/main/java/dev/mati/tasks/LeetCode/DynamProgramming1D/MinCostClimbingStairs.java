package dev.mati.tasks.LeetCode.DynamProgramming1D;

public class MinCostClimbingStairs {
    private int minCost = Integer.MAX_VALUE;
    public int minCostClimbingStairs(int[] cost) {
        int floor = cost.length;
        DFSdecisionTree(cost, 0, floor, 0);
        DFSdecisionTree(cost, 1, floor, 0);
        return minCost;
    }
    private void DFSdecisionTree(int[] cost, int c, int floor, int total) {
        if(c >= floor) {
            minCost = Integer.min(minCost, total);
            return;
        }
        DFSdecisionTree(cost, c + 1, floor, total + cost[c]);
        DFSdecisionTree(cost, c + 2, floor, total + cost[c]);
    }
}
