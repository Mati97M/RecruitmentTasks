package dev.mati.tasks.LeetCode.BitManipulation;

import java.util.Arrays;
import java.util.HashSet;

public class MissingNumber {
    //XOR erases two identical numbers to zero. 0 ^ n == n; XOR has commutative property
    public int missingNumberXOR(int[] nums) {   //O(N) in time, O(1) in space.
        int res = 0;
        for(int i = 0; i <= nums.length; i++) {
            res ^= i;
        }
        for(int n: nums) {
            res ^= n;
        }
        return res;
    }
    public int missingNumberSumsDiff(int[] nums) {  //O(N) in time, O(1) in space
        int fullSum = 0;
        for(int i = 0; i <= nums.length; i++) {
            fullSum += i;
        }
        int actSum = 0;
        for(int n: nums) {
            actSum += n;
        }
        return fullSum - actSum;
    }
    public int missingNumberInSet(int[] nums) { //O(N) in time, O(N) in space
        HashSet<Integer> present = new HashSet<>();
        for(int n: nums) {
            present.add(n);
        }
        int curr = 0;
        while (present.contains(curr)) {
            curr++;
        }
        return curr;
    }
    public int missingNumberInSortedVals(int[] nums) {  //O(NlogN) in time, O(1) in space
        Arrays.sort(nums);
        int expected = 0;
        for (int num : nums) {
            if (expected != num) {
                return expected;
            }
            expected++;
        }
        return expected;
    }
}
