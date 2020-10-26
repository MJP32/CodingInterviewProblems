package Amazon.assessment;

import java.util.Arrays;

public class BetaTesting {
    public static void main(String[] args) {
        int[] tests = {30, 10, 40, 20, 50};
        int days = 2;

//        int[] tests = {74303, 20452, 66120, 44483, 5370, 68585};
//        int days = 5;
        BetaTesting betaTesting = new BetaTesting();
        System.out.println("min complexities are: " + betaTesting.findMinComplexity(tests, days));
    }

    public int findMinComplexity(int[] jobDifficulty, int d) {
        int numJobs = jobDifficulty.length;
        if (numJobs < d) {
            return -1;
        }

        int res[][] = new int[jobDifficulty.length + 1][d + 1];

        int max_complexity = 0;
        for (int i = 1; i <= numJobs; i++) {
            max_complexity = Math.max(max_complexity, jobDifficulty[i - 1]);
            res[i][1] = max_complexity;
        }
        for (int[] arr : res) {
            System.out.println(Arrays.toString(arr));
        }
        for (int j = 2; j <= d; j++) {
            for (int i = j; i <= numJobs; i++) {
                int maxComplexity = 0;
                int minValue = Integer.MAX_VALUE;
                System.out.println();
                for (int row = i; row > j - 1; row--) {
                    maxComplexity = Math.max(jobDifficulty[row - 1], maxComplexity);
                    minValue = Math.min(minValue, maxComplexity + res[row - 1][j - 1]);
                }

                res[i][j] = minValue;
            }
        }

        for (int[] arr : res) {
            System.out.println(Arrays.toString(arr));
        }
        return res[numJobs][d];
    }
}
