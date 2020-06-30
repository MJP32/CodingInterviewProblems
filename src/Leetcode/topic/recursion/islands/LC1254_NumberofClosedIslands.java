package Leetcode.topic.recursion.islands;

public class LC1254_NumberofClosedIslands {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1,1,1,1,1,1,1,0},
                {1,0,0,0,0,1,1,0},
                {1,0,1,0,1,1,1,0},
                {1,0,0,0,0,1,0,1},
                {1,1,1,1,1,1,1,0}};

        System.out.println(new LC1254_NumberofClosedIslands().closedIsland(arr));


    }
    public int closedIsland(int[][] grid) {
        if(grid ==null || grid.length ==0)
            return 0;

        int closedIslands =0;

        for (int i = 1; i < grid.length-1; i++) {
            for (int j = 1; j < grid[0].length-1; j++) {
                if(grid[i][j] ==0){
                    if(closedIslands(grid, i,j )){
                        closedIslands++;
                    }

                }
            }

        }
        return closedIslands;
    }

    private boolean closedIslands(int[][] grid, int i, int j) {

        if(grid[i][j] == -1 || grid[i][j] ==1){
            return true;
        }
        if(i ==0 || j==0|| i==grid.length-1||j == grid[0].length-1 ){
           return false;
        }
        grid[i][j] =-1;

        boolean left = closedIslands(grid, i, j - 1);
        boolean right = closedIslands(grid, i, j+1);
        boolean up = closedIslands(grid, i-1, j);
        boolean down = closedIslands(grid, i+1, j);

        return left && right && up && down;
    }
}
