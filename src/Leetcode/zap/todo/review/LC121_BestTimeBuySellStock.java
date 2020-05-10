package Leetcode.zap.todo.review;

public class LC121_BestTimeBuySellStock {
    public static void main(String[] args) {
        System.out.println(new LC121_BestTimeBuySellStock().maxProfit(new int[]{7,1,5,3,6,4}));
    }
    public int maxProfit(int[] prices){
        int profit =0;
        int min = Integer.MAX_VALUE;
        int max;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            else{
                profit = Math.max(profit, prices[i]-min);
            }
        }

        return profit;
    }
}
