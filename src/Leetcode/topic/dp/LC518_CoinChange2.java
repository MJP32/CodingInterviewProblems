package Leetcode.topic.dp;

import java.util.Arrays;

public class LC518_CoinChange2 {
    public static void main(String[] args) {
        System.out.println(new LC518_CoinChange2().change(5, new int[]{1,2,5}));

    }

    public int change(int amount, int[] coins) {




        //        1 , 1 ,2, 3, 4, 5
        //  1     1   1  1  1  1. 1
        //  2     1   1. 2  2  3  3
        //  5     1   1. 2. 2  3. 4

        int[] arr = new int[amount+1];

        arr[0]=1;
        for(int coin: coins){
            for(int j =coin; j < arr.length;j++){
                arr[j] += arr[j-coin];
            }

        }

        System.out.println(Arrays.toString(arr));
        return arr[arr.length-1];
    }}

