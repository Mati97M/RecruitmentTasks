package dev.mati.tasks.LeetCode.BitManipulation;

public class ReverseInteger {
    public static void main(String[] args) {
        int n = 1534236469;
        System.out.println(new ReverseInteger().reverse(n));
    }
    public int reverse(int x) {
        int rvsd = 0;
        while(x != 0) {
            int digit = x % 10;
            if(rvsd > Integer.MAX_VALUE / 10 ||
                    rvsd == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < digit) {
                return 0;
            }
            if(rvsd < Integer.MIN_VALUE / 10 ||
                    rvsd == Integer.MIN_VALUE && Integer.MIN_VALUE % 10  > digit) {
                return 0;
            }

            rvsd = (rvsd * 10) + digit;
            x /= 10;
        }
        return rvsd;
    }
}
