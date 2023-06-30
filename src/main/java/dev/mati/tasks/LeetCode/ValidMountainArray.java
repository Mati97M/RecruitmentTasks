package dev.mati.tasks.LeetCode;

public class ValidMountainArray {
    public static void main(String[] args) {
        System.out.println("[2,1] : " + validMountainArray(new int [] {2,1}));
        System.out.println("[3,5,5] : " + validMountainArray(new int [] {3,5,5}));
        System.out.println("[0,3,2,1] : " + validMountainArray(new int [] {0,3,2,1}));
    }
    public static boolean validMountainArray(int[] arr) {
        if(arr.length <3){
            return false;
        }
        //split array into to subarrays, monotonicly
        int l =0;   //for ascending travelsal
        int r = arr.length -1;  //for descending travelsal
        while(l+1 < arr.length-1 && arr[l] < arr[l+1])
            l++;    //looking for peak
        while(r-1 >0 && arr[r] < arr[r-1])
            r--;    //looking for peak
        return l == r;  //mountain should have only one peak
    }
}
