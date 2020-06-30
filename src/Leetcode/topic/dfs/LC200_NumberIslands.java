package Leetcode.topic.dfs;

public class LC200_NumberIslands {
    public static void main(String[] args) {


        //char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] grid2 = new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};

        LC200_NumberIslands lc200 = new LC200_NumberIslands();
        //System.out.println(lc200.numIslands(grid));
        System.out.println(lc200.numIslands(grid2));


    }

    public int numIslands(char[][] grid) {

        if(grid == null || grid.length ==0){
            return 0;
        }

        int numIslands = 0;

        for(int i=0;i< grid.length;i++){
            for (int j = 0; j < grid[0].length; j++) {
               if(grid[i][j] == '1'){

                   numIslands += dfs(grid, i,j);
               }

            }
        }


        return numIslands;
    }

    private int dfs(char[][] grid, int i, int j) {

        if(i < 0 || i >= grid.length || j < 0 || j>= grid[i].length || grid[i][j] == '0' ){
            return 0;
        }

        grid[i][j] = '0';


        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);

        return 1;

    }
}
