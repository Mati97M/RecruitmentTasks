package dev.mati.tasks.LeetCode.ArraysHashing;

import java.util.HashSet;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> uniqueNums = new HashSet<Integer>();
        for(int i: nums) {
            if(!uniqueNums.add(i))
                return true;
        }
        return false;
    }
}
