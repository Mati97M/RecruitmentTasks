package dev.mati.tasks.LeetCode.BitManipulation;

public class CountingBits {
    //O(N) in time, reapiting patterns
    public int[] countBitsLinearly(int n) {
        int[] ans = new int[n + 1];
        int offset = 1;
        int nxtOffset = offset * 2;
        for(int i = 1; i < ans.length; i++) {
            ans[i] = 1 + ans[i - offset];
            if(i + 1 == nxtOffset) {
                offset = nxtOffset;
                nxtOffset *= 2;
            }
        }
        return ans;
    }
    //O(NlogN) in time,dividing by 2
    public int[] countBitsLinearithmicly(int n) {
        int[] ans = new int[n + 1];
        for(int i = 0; i < ans.length; i++) {
            int count = 0;
            int tmp = i;
            while(tmp != 0) {
                if(tmp % 2 == 1) {
                    count++;
                }
                tmp /= 2;
            }
            ans[i] = count;
        }
        return ans;
    }
}
