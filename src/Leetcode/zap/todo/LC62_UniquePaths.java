package Leetcode.zap.todo;

public class LC62_UniquePaths {
    public static void main(String[] args) {
        LC62_UniquePaths lc62 =new LC62_UniquePaths();
        System.out.println(lc62.uniquePaths(3, 2));
    }


    public int uniquePaths(int m, int n) {
        int[][] obstacleGrid = new int[m][n];

        for (int i = 0; i < m; i++) {
            obstacleGrid[i][0] =1;
        }

        for (int i = 0; i < n; i++) {
            obstacleGrid[0][i] =1;
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1 ; j < obstacleGrid[0].length; j++) {
                obstacleGrid[i][j] = obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
            }

        }

        return obstacleGrid[m-1][n-1];
    }
}