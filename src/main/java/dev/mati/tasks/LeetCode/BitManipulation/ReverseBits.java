package dev.mati.tasks.LeetCode.BitManipulation;

public class ReverseBits {
    //using summation
    public int reverseBitsSum(int n) {
        int reversed = 0;
        int weight = 31;
        while(n != 0) {
            int bit = n & 1;
            if(bit == 1) {
                reversed |= (bit << weight);
            }
            weight--;
            n >>>= 1;
        }
        return reversed;
    }

    //using | operator
    public int reverseBitsBitOr(int n) {
        int reversed = 0;
        int weight = 31;
        while(n != 0) {
            int bit = n & 1;
            if(bit == 1) {
                reversed |= (bit << weight);
            }
            weight--;
            n >>>= 1;
        }
        return reversed;
    }
}
