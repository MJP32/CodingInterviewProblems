package Leetcode.zap.todo.review;

import java.util.Arrays;

public class LC188_BestTimeBuySellStock4 {
    public static void main(String[] args) {
        System.out.println(new LC188_BestTimeBuySellStock4().maxProfit(2,new int[]{7,1,5,3,6,4}));
    }
    public int maxProfit(int k, int[] prices) {

        int[][] arr =new int[k+1][prices.length+1];

        for (int i =1; i < arr.length;i++) {
            int max =-1;
            for (int j = 0; j < arr[0].length; j++) {

            }

        }


        System.out.println(Arrays.deepToString(arr));

        return 1;
    }
}
