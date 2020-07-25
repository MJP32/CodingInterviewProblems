package Leetcode.topic.dp;

import java.util.Arrays;

public class LC44_WildcardMatching {
    public static void main(String[] args) {
//        System.out.println(new LC44_WildcardMatching().isMatch("acdcb", "a*c?b"));
//        System.out.println(new LC44_WildcardMatching().isMatch("aa", "*"));
        System.out.println(new LC44_WildcardMatching().isMatch("adceb", "*a*b"));
    }

    public boolean isMatch(String s, String p) {

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();



        dp[0][0] = true;
        for(int j = 1; j < dp[0].length; j++) {
            if(p.charAt(j-1) == '*')
                dp[0][j] = dp[0][j-1];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (pattern[j - 1] == '?' || pattern[j - 1] == str[i - 1]) {

                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }

            }

        }

        System.out.println(Arrays.deepToString(dp));
        return dp[s.length()][p.length()];

    }
}
