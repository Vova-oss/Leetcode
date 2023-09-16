package com.example.leetcode.Problems.Done;

public class _122_M_BestTimeToBuyAndSellStock_II {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4})); // 7
        System.out.println(maxProfit(new int[]{1,2,3,4,5})); // 4
        System.out.println(maxProfit(new int[]{7,6,4,3,1})); // 0
    }

    public static int maxProfit(int[] prices) {
        int bottom = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++){
            int currentPrice = prices[i];
            if (bottom == -1 || currentPrice < bottom)
                bottom = currentPrice;

            if (currentPrice > bottom) {
                profit = profit + (currentPrice - bottom);
                bottom = -1;
            }

            if (i != prices.length - 1 && currentPrice < prices[i+1])
                bottom = currentPrice;
        }
        return profit;
    }
}
