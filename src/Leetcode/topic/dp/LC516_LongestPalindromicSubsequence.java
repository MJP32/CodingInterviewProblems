package Leetcode.topic.dp;

import java.util.Arrays;

public class LC516_LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(new LC516_LongestPalindromicSubsequence().longestPalindromeSubseq("agbdda"));
        System.out.println(new LC516_LongestPalindromicSubsequence().calculate1(new char[]{'a','g','b','d','d','a'}));
    }

    public int calculate1(char []str){
        int T[][] = new int[str.length][str.length];
        for(int i=0; i < str.length; i++){
            T[i][i] = 1;
        }
        for(int l = 2; l <= str.length; l++){
            for(int i = 0; i < str.length-l + 1; i++){
                int j = i + l - 1;
                if(l == 2 && str[i] == str[j]){
                    T[i][j] = 2;
                }else if(str[i] == str[j]){
                    T[i][j] = T[i + 1][j-1] + 2;
                }else{
                    T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(T));
        return T[0][str.length-1];
    }
    public int longestPalindromeSubseq(String s) {

        int[][] dp = new int[s.length()][s.length()];

        for(int i =0; i < s.length();i++){
            dp[i][i] =1;
        }


        for (int l = 2; l <= s.length(); l++) {
            for (int i = 0; i < s.length()-l+1; i++) {
                int j =i+l-1;
                if (l==2 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] =2;
                }
                else if(s.charAt(i) == s.charAt(j) ){
                    dp[i][j] = dp[i+1][j-1] +2;
                }
                else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }

            }
        }
        System.out.println(Arrays.deepToString(dp));

        return dp[0][s.length()-1];
    }
}
