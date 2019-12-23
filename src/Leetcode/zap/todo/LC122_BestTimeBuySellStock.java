package Leetcode.zap.todo;

public class LC122_BestTimeBuySellStock {
    public static void main(String[] args) {
        LC122_BestTimeBuySellStock lc122 = new LC122_BestTimeBuySellStock();
        System.out.println(lc122.maxProfit(new int[]{7,1,2,3,5,3,6,4}));
    }
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
