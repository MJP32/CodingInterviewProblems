package AlgoExpert.DP;

import java.util.Arrays;

public class MaxProfitKTransactions {
    public static void main(String[] args) {
        System.out.println(maxProfitWithKTransactions(new int[]{5,11,3,50,60,90}, 2));
    }

    public static int maxProfitWithKTransactions(int[] prices, int k) {
        int[][] profits = new int[k+1][prices.length+1];


        for (int i = 1; i < k+1; i++) {
            for (int j = 1; j < prices.length+1; j++) {
                profits[i][j] = Math.max(profits[i-1][j], 1);
            }
        }


        int profit = 0;

        for(int[] arr :profits){

            System.out.println(Arrays.toString(arr));
        }


        return profit;
    }
}
