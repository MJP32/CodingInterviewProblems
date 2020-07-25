package Leetcode.topic.group.stockbuysell;

public class LC123_BestTimeBuySellStock3 {
    public static void main(String[] args) {
        System.out.println(new LC123_BestTimeBuySellStock3().maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }

    public int maxProfit(int[] prices) {

        if(prices == null || prices.length ==0){
            return 0;
        }


        //3,2,6,5,0,3
        //0,0,4,4,4,4
        int k =2;
        int[][] arr = new int[k+1][prices.length];


        for(int t =1; t < k+1;t++){
            int currMax = Integer.MIN_VALUE;
            for(int d = 1; d< arr[0].length;d++ ){
                currMax = Math.max(currMax, arr[t-1][d-1] -prices[d-1] );
                arr[t][d] = Math.max(arr[t][d-1], currMax +prices[d]);
            }
        }



        return arr[k][prices.length-1];
    }
}
