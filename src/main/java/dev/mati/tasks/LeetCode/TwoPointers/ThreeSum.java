package dev.mati.tasks.LeetCode.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0};
        threeSum(nums).forEach(list -> System.out.println(list));
        System.out.println();
        threeSum(new int[]{-1,0,1,2,-1,-4}).forEach(list -> System.out.println(list));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for(int s = 0; s <= nums.length - 3; s++) {
            if(s != 0 && nums[s] == nums[s - 1])
                continue;
            int e = nums.length - 1;
            int m = s + 1;
            while(m < e) {  // two sum
                if(e != nums.length - 1 && nums[e] == nums[e + 1]) {
                    e--;
                    continue;
                }
                if(m != s + 1 && nums[m] == nums[m - 1]) {
                    m++;
                    continue;
                }
                if(nums[e] + nums[m] == -nums[s]) {
                    ArrayList<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[s]);
                    triplet.add(nums[m]);
                    triplet.add(nums[e]);
                    triplets.add(triplet);
                    m++;

                } else if(nums[e] + nums[m] > -nums[s]) {
                    e--;
                } else
                    m++;
            }
        }
        return triplets;
    }
}
