package Leetcode.topic.slidingwindow;

import java.util.Arrays;

public class LC727_MinimumWindowSubsequence {
    public static void main(String[] args) {
        System.out.println(new LC727_MinimumWindowSubsequence().minWindow("abcdebdde", "bde"));
    }
    public String minWindow(String S, String T) {

        int m = T.length(), n = S.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = -1;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (T.charAt(i - 1) == S.charAt(j - 1)) {
                    if (dp[i - 1][j - 1] == -1) {
                        dp[i][j] = -1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                } else {
                    if (dp[i][j - 1] == -1)
                        dp[i][j] = -1;
                    else
                        dp[i][j] = dp[i][j - 1] + 1;
                }
                if (i == m && dp[i][j] != -1 && ans > dp[i][j]) {
                    ans = Math.min(ans, dp[i][j]);
                    start = j - ans;
                }
            }
        }

        for(int[] arr : dp){
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(ans);
        return ans == Integer.MAX_VALUE ? "" : S.substring(start, start + ans);
    }
}
