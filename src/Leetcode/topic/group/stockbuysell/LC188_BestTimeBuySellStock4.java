package Leetcode.topic.group.stockbuysell;

import java.util.Arrays;

public class LC188_BestTimeBuySellStock4 {
    public static void main(String[] args) {
        System.out.println(new LC188_BestTimeBuySellStock4().maxProfit(2, new int[]{5,11,3,50,60,90}));
//        System.out.println(new LC188_BestTimeBuySellStock4().maxProfit(2, new int[]{2,4,1}));
    }

    public int maxProfit(int k, int[] prices) {

        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;

        int[][] profits = new int[k+1][prices.length];


        for (int t = 1; t < k+1 ; t++) {

            int currMax = Integer.MIN_VALUE;

            for(int d =1; d< prices.length;d++){
                currMax = Math.max(currMax, profits[t-1][d-1]- prices[d-1]);
                profits[t][d] = Math.max(profits[t][d-1], currMax + prices[d]);
            }

        }

        System.out.println(Arrays.deepToString(profits));


        return profits[k][prices.length-1];
    }
}
