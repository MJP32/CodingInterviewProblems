package AlgoExpert.DP;

import java.util.Arrays;

public class MinNumberOfCoinsForChange {
    public static void main(String[] args) {
        System.out.println(minNumberOfCoinsForChange(6, new int[]{1,2,4}));
    }
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        // Write your code here.
        int[] coins = new int[n+1];
        Arrays.fill(coins, Integer.MAX_VALUE);
        coins[0] =0;
        int toCompare = 0;
        for(int i =0;i< denoms.length ;i++){
            for(int j =1;j < coins.length;j++ ){
                if(coins[j] >=denoms[i]){
                    if(coins[j-denoms[i]] == Integer.MAX_VALUE){
                        toCompare= coins[j-denoms[i]];

                    }
                    else{
                        toCompare= coins[j-denoms[i]]+1;
                    }

                    coins[j] = Math.min(coins[j], toCompare);
                }
            }
        }
        return coins[n];
    }
}
