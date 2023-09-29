package dev.mati.tasks.LeetCode.binarySearch;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {5,1,3};
        int target = 1;
        System.out.println(search(arr,target));

        arr = new int[] {4,5,1,2,3};
        //target = 1;
        System.out.println(search(arr,target));

        arr = new int[] {4,5,6,7,0,1,2};
        target = 0;
        System.out.println(search(arr,target));
    }
    public static int search(int[] nums, int target) {
        //divide arr into two subarrays & find the last index of the first one
        // the last index of 1st half: nums[last + 1] < nums[last]

        //check whether there was any rotation. If it was not, searched the whole input array
        int l = 0;
        int r = nums.length - 1;
        int last = 0;
        if(nums[0] > nums[nums.length - 1]) {
            while(l <= r) {
                int m = (l + r) / 2;
                if(nums[m + 1] < nums[m]) {
                    last = m;
                    break;
                }
                if(nums[l] <= nums[m])
                    l = m + 1;
                else
                    r = m - 1;
            }
            l = 0;
            r = nums.length - 1;
            //decide in which subarray can be the target

            if(nums[last] >= target && nums[0] <= target) {
                r = last;
            } else if(nums[last + 1] <= target && target <= nums[r]) {
                l = last + 1;
            } else
                return -1;
        }
        //binary search for the target
        while(l <= r) {
            int m = (l + r) / 2;
            if(nums[m] == target)
                return m;
            else if (nums[m] < target)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }

}
