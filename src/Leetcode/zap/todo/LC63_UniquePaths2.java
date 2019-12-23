package Leetcode.zap.todo;

public class LC63_UniquePaths2 {
    public static void main(String[] args) {
        LC63_UniquePaths2 lc63= new LC63_UniquePaths2();
        int[][] grid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(lc63.uniquePathsWithObstacles(grid));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0 ; j < obstacleGrid[0].length; j++) {
                if(obstacleGrid[i][j]==1)
                    obstacleGrid[i][j] = -1;
            }

        }

        for (int i = 0; i < obstacleGrid.length; i++) {
            if(obstacleGrid[i][0] !=-1)
                 obstacleGrid[i][0] =1;
            else
                break;
        }

        for (int i = 0; i <obstacleGrid[0].length; i++) {
            if(obstacleGrid[0][i] !=-1)
                    obstacleGrid[0][i] =1;
            else
                break;
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1 ; j < obstacleGrid[0].length; j++) {
                if(obstacleGrid[i-1][j]!=-1 && obstacleGrid[i][j]!=-1)
                    obstacleGrid[i][j] += obstacleGrid[i-1][j];
                if(obstacleGrid[i][j-1]!=-1 && obstacleGrid[i][j] !=-1)
                    obstacleGrid[i][j] += obstacleGrid[i][j-1];

            }

        }
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==-1){
            return 0;
        }
        else
            return obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
