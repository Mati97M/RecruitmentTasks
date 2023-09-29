package dev.mati.tasks.LeetCode.binarySearch;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        System.out.println(findMin(arr));

        arr = new int[]{2,1};
        System.out.println(findMin(arr));
    }
    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int min = nums[0];

        while(l <= r) {
            if(nums[l] <= nums[r]) {
                min = Math.min(nums[l],min);
                break;
            }
            int m = (l + r) / 2;
            min = Math.min(min,nums[m]);
            if ( nums[l] <= nums[m] ) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return min;
    }
}
