package dev.mati.tasks.LeetCode.binarySearch;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1,3};
        int[] arr2 = {2};
        System.out.println(findMedianSortedArrays(arr1, arr2));

        arr1 = new int[] {1,2};
        arr2 = new int[] {3,4};
        System.out.println(findMedianSortedArrays(arr1, arr2));

    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int l = 0;
        int h = nums1.length;

        while(l <= h) {
            int m1 = (l + h) / 2;
            int l1 = (m1 == 0) ? Integer.MIN_VALUE : nums1[m1 - 1];
            int r1 = (m1 == nums1.length) ? Integer.MAX_VALUE : nums1[m1];
            int m2 = (nums1.length + nums2.length + 1) / 2  - m1;
            int l2 = (m2 == 0) ? Integer.MIN_VALUE : nums2[m2 - 1];
            int r2 = (m2 == nums2.length) ? Integer.MAX_VALUE : nums2[m2];

            if(l1 <= r2 && l2 <= r1) {
                if((nums1.length + nums2.length) % 2 == 0)
                    return (double)(Integer.max(l1,l2) + Integer.min(r1,r2)) / 2;
                else
                    return (double) Integer.max(l1,l2);
            } else if (l2 > r1)
                l = m1 + 1;
            else
                h = m1 - 1;
        }

        return 0.0;
    }
}
