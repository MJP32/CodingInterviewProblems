package Grokking.Ch16_Knapsack;

public class SubsetSum {
    public static void main(String[] args) {
        SubsetSum ss = new SubsetSum();
        int[] num = { 1, 2, 3, 7 };
        System.out.println(ss.canPartition(num, 6));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.canPartition(num, 10));
        num = new int[] { 1, 3, 4, 8 };
        System.out.println(ss.canPartition(num, 6));
    }

    private boolean canPartition(int[] num, int sum) {

        int n = num.length;
        boolean [][] dp = new boolean[n][sum +1];

        // populate the sum=0 columns, as we can always form '0' sum with an empty set
        for (int i = 0; i < n; i++)
            dp[i][0] = true;

        for (int i = 1; i <=sum ; i++) {
            dp[0][i] = (num[0] == i ? true : false );
        }
        for (int i = 1; i < num.length; i++) {
            for (int s = 1; s <= sum ; s++) {
                if (dp[i-1][s]) {
                    dp[i][s] = dp[i-1][s];
                }
                else if(s >= num[i]){
                    dp[i][s] = dp[i-1][s-num[i]];
                }

            }
        }
        return dp[num.length-1][sum];
    }
}
