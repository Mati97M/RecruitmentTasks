package dev.mati.tasks.LeetCode;

public class ThirdMax {
    public static void main(String[] args) {
        int[] arr = new int[]{2,2,3,1};
        solution(arr);
    }
    public static int solution(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for (int num : nums) {
            if (num == first || num == second || num == third)
                continue;
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second) {
                third = second;
                second = num;
            } else if (num > third) {
                third = num;
            }
        }
        if(third == Long.MIN_VALUE) {
            return (int) first;
        } else {
            return (int) third;
        }
    }
}
