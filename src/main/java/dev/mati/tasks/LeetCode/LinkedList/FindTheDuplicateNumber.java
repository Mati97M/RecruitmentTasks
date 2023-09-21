package dev.mati.tasks.LeetCode.LinkedList;

public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
    public static int findDuplicate(int[] nums) {
        int slow1 = 0;
        int fast = 0;
        do {
            slow1 = nums[slow1];
            fast = nums[nums[fast]];
        } while(nums[slow1] != nums[fast]);

        int slow2 = 0;
        while(slow2 != slow1) {
            slow2 = nums[slow2];
            slow1 = nums[slow1];
        }

        return slow2;
    }
}
