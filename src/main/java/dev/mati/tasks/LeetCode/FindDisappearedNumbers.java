package dev.mati.tasks.LeetCode;

import java.util.*;
import java.util.stream.IntStream;

public class FindDisappearedNumbers {
    public static void main(String[] args) {
        int[] arr = new int[] {4,3,2,7,8,2,3,1};
        solution(arr);
    }
    public static List<Integer> solution(int[] nums) {
        IntStream stream = Arrays.stream(nums);
        Set<Integer> disappeared = new HashSet<>();
        for (int num : nums) {
            disappeared.add(num);
        }
        int expected = 1;

        while(expected <= nums.length) {
            if(!disappeared.remove(expected))
                disappeared.add(expected);
            expected++;
        }
        return disappeared.stream().toList();
    }
    public static List<Integer> solution2(int[] nums) {
//        int[] expected = new int[nums.length];
//        for (int i = 0; i < expected.length; i++) {
//            expected[i] = i + 1;
//        }
        int expected = 1;
        Arrays.sort(nums);
        List<Integer> missing = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != expected) {
                missing.add(expected);
            } else {
                while(expected != nums[i]) {
                    missing.add(expected);
                }
            }
            expected++;
        }
        return missing;
    }
}
