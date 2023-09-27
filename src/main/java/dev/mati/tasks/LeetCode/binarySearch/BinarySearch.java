package dev.mati.tasks.LeetCode.binarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int target = 9;
        int[] arr = {-1,0,3,5,9,12};
        System.out.println(search(arr,target));

        target = 5;
        arr = new int[]{5};
        System.out.println(search(arr,target));
    }
    public static int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        while(s <= e) {
            int m = (s + e) / 2;
            if(target == nums[m])
                return m;
            else if(target < nums[m]) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }
        return -1;
    }
}
