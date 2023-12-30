package dev.mati.tasks.LeetCode.Greedy;

import java.util.LinkedList;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(new GasStation().canCompleteCircuit(gas, cost));
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        int start = 0;
        int tank = 0;
        for(int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
            int diff = gas[i] - cost[i];
            tank += diff;
            if(tank < 0) {
                tank = 0;
                start = i + 1;
            }
        }
        if(start == gas.length || gasSum < costSum) {
            return -1;
        }
        return start;
    }

    public int canCompleteCircuitSlooooow(int[] gas, int[] cost) {
        LinkedList<Integer> diffIndices = new LinkedList<>();
        for(int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            if(diff >= 0) {
                diffIndices.offer(i);
            }
        }
        if(diffIndices.isEmpty()) {
            return -1;
        }
        for(int diffInd: diffIndices) {
            if(isValidSol(gas, cost, diffInd)) {
                return diffInd;
            }
        }
        return -1;


    }
    private boolean isValidSol(int[] gas, int[] cost, int diffInd) {
        int j = diffInd + 1;
        int tank = gas[diffInd] - cost[diffInd];
        int n = gas.length;
        while(j%n != diffInd) {
            tank += gas[j%n] - cost[j%n];
            if(tank < 0) {
                break;
            }
            j++;
        }
        return j % n == diffInd;
    }
}
