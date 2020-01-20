package Leetcode.topic.trees;

import java.util.Arrays;

public class LC97_UniqueBST2 {
    public static void main(String[] args) {

        System.out.println(new LC97_UniqueBST2().numTrees(3));
    }
    public int numTrees(int n) {

        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;


        for(int i =2; i<= n; i++){
            for (int j = 1; j <= i; ++j) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        System.out.println(Arrays.toString(dp));

        return dp[n];
    }


    public int numTreesRecursive(int n) {
        if(n <=1) return 1;

        int count =0;

        for(int i =0; i< n;i++){
            count +=numTrees(i) * numTrees(n-i-1);
        }

        return count;
    }


}
