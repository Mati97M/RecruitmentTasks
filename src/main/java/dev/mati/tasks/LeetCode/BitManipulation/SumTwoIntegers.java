package dev.mati.tasks.LeetCode.BitManipulation;

public class SumTwoIntegers {
    public static void main(String[] args) {
        System.out.println(new SumTwoIntegers().getSum(7,7));
    }
    public int getSum(int a, int b) {
        while(b != 0) {
            int xor = a ^ b;
            int carry = (a & b) << 1;
            a = xor;
            b = carry;
        }
        return a;
    }
}
