package Leetcode.zap.todo.submit;

public class LC70_ClimbingStairs {
    public static void main(String[] args) {
        LC70_ClimbingStairs lc70 = new LC70_ClimbingStairs();
        System.out.println(lc70.climbStairs(3));
    }

    public int climbStairs(int n){
        int dp[] =new int[n+1];
        dp[0] = 1;
        dp[1] = 1;


        for (int i = 2 ; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
