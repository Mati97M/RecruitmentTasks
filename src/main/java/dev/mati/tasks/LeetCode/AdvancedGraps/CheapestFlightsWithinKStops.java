package dev.mati.tasks.LeetCode.AdvancedGraps;

import java.util.Arrays;

public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        int[][] flights = {{0,3,7},{4,5,3},{6,4,8},{2,0,10},{6,5,6},{1,2,2},{2,5,9},{2,6,8},{3,6,3},{4,0,10},{4,6,8},{5,2,6},{1,4,3},{4,1,6},{0,5,10},{3,1,5},{4,3,1},{5,4,10},{0,1,6}};
        int n = 7;
        int src = 2;
        int dst = 4;
        int k = 1;
        System.out.println(new CheapestFlightsWithinKStops().findCheapestPrice(n,flights, src, dst, k));
    }
     public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
         int[] price = new int[n];
         for(int i = 0; i < n; i++)
             price[i] = Integer.MAX_VALUE;
         price[src] = 0;

         for(int i = 0; i < k + 1; i++) {
             int[] newPrices = Arrays.copyOf(price, price.length);
             for(int[] f: flights) {
                 int from = f[0];
                 int to = f[1];
                 int p = f[2];

                 if(price[from] == Integer.MAX_VALUE)
                     continue;
                 if(price[from] + p < newPrices[to])
                     newPrices[to] = price[from] + p;
             }
             price = newPrices;
         }
         if(price[dst] == Integer.MAX_VALUE) {
             return -1;
         }
         return price[dst];
    }
}
