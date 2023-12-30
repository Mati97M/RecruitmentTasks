package dev.mati.tasks.LeetCode.Greedy;

import java.util.HashSet;

public class MergeTripletsToTargetTriplet {
    public static void main(String[] args) {
        int[][] triplets = {{2,5,3},{1,8,4},{1,7,5}};
        int[] target = {2,7,5};
        System.out.println(new MergeTripletsToTargetTriplet().mergeTriplets(triplets,target));
    }
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        HashSet<Integer> validTriplets = new HashSet<>();
        for(int t = 0; t < triplets.length; t++) {
            for(int i = 0; i < 3; i++) {
                if(triplets[t][i] > target[i]) {
                    break;
                }
                if(i == 2) {
                    validTriplets.add(t);
                }
            }
        }
        boolean fst = false;
        boolean sd = false;
        boolean trd = false;
        for(int t: validTriplets) {
            if(triplets[t][0] == target[0]) {
                fst = true;
            }
            if(triplets[t][1] == target[1]) {
                sd = true;
            }
            if(triplets[t][2] == target[2]) {
                trd = true;
            }
            if(fst && sd && trd) {
                return true;
            }
        }
        return false;
    }
}
