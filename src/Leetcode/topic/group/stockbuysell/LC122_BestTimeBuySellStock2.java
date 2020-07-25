package Leetcode.topic.group.stockbuysell;

public class LC122_BestTimeBuySellStock2 {
    public static void main(String[] args) {
        System.out.println(new LC122_BestTimeBuySellStock2().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];

        }
        return maxProfit;
    }
}
