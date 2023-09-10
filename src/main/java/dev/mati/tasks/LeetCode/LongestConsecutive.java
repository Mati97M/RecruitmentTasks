package dev.mati.tasks.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class LongestConsecutive {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        int result = 0;
        HashSet<Integer> distinctElements = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            distinctElements.add(nums[i]);
        }
        var sequences = new HashMap<Integer, LinkedList>(); //first,otherInList
        for(int i = 0; i < nums.length; i++) {
            if(!distinctElements.contains(nums[i]-1)) {
                sequences.put(nums[i],new LinkedList<Integer>());
            }
        }
        for(int firstInSequence: sequences.keySet()) {
            int next = firstInSequence + 1;
            for(;;next++) {
                if(!distinctElements.contains(next)) {
                    result = Math.max(
                            result,sequences.get(firstInSequence).size() + 1);
                    break;
                }
                sequences.get(firstInSequence).add(next);
            }
        }
        return result;
    }
}
