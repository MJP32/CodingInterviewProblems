package Leetcode.zap.todo.finish;

import java.util.Arrays;

public class LC322_CoinChange {
    public static void main(String[] args) {
        LC322_CoinChange lc322 = new LC322_CoinChange();
        System.out.println(lc322.coinChange(new int[]{1,2,5},11));
    }
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for (int i = 0; i <= amount ; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(coins[j] <=i) {
                    dp[i] = Math.min(dp[i],1+dp[i-coins[j]]);
                }
            }

        }
        System.out.println(Arrays.toString(dp));

        return dp[amount] >amount ? -1:dp[amount];
    }
}
