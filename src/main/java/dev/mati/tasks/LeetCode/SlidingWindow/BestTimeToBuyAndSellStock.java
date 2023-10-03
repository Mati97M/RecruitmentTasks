package dev.mati.tasks.LeetCode.SlidingWindow;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.printf("Max profit is: %d%n", maxProfit(prices));
        prices = new int[] {7,6,4,3,1};
        System.out.printf("Max profit is: %d%n", maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int result = 0;
        if(prices.length == 1)
            return result;

        int l = 0;
        int r = 0;

        while(l < prices.length && r < prices.length) {
            int diff = prices[r] - prices[l];
            if(diff == 0) {
                r++;
                continue;
            } else if(diff > 0) {
                result = Integer.max(result, diff);
                r++;
            } else {
                l++;
            }
        }
        return result;
    }

}
