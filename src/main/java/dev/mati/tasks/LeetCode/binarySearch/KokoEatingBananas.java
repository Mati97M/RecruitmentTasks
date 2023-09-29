package dev.mati.tasks.LeetCode.binarySearch;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {1,1,1,999999999};
        int h = 10;
        System.out.println(minEatingSpeed(piles,h));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for(int i = 1; i < piles.length; i++) {
            if(max < piles[i])
                max = piles[i];
        }
        int left = 1;
        int right = max;

        while(left < right) {
            int m = (left + right) / 2;
            int currTime = 0;
            for(int i = 0; i < piles.length; i++) {
                currTime += piles[i] / m;
                if(piles[i] % m != 0)
                    currTime++;
            }
            if(currTime <= h) {
                right = m;
            } else
                left = m + 1;
        }
        return right;
    }
}
