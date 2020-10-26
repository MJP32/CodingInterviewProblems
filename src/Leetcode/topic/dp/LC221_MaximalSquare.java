package Leetcode.topic.dp;

import java.util.Arrays;

public class LC221_MaximalSquare {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','1','1','1'}};

        System.out.println(new LC221_MaximalSquare().maximalSquare(board));
    }
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];

        int max =0;


        for(int i =0; i< matrix[0].length;i++){
            dp[0][i] = matrix[0][i]-'0';
            max = Math.max(max, dp[0][i]);
        }

        for(int i =0; i< matrix.length;i++){
            dp[i][0] = matrix[i][0]-'0';
            max = Math.max(max, dp[i][0]);
        }


        for(int i =1; i < matrix.length;i++){
            for(int j =1; j < matrix[0].length;j++){
                if(matrix[i][j] != '0'){
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]))+1;
                    max = Math.max(max, dp[i][j]);

                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return max*max;
    }
}
