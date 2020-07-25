package Leetcode.topic.group.stockbuysell;

public class LC121_BestTimeBuySellStock {
    public static void main(String[] args) {
        System.out.println(new LC121_BestTimeBuySellStock().maxProfit(new int[]{7,1,5,3,6,4}));
    }
    public int maxProfit(int[] prices){

        if(prices == null || prices.length < 2){
            return 0;
        }
        int maxProfit =0;
        int min =prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(prices[i-1], min);
            maxProfit = Math.max(maxProfit,prices[i]-min);

        }
        return maxProfit;
    }
}
