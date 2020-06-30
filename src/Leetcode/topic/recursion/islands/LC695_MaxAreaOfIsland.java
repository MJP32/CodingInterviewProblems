package Leetcode.topic.recursion.islands;

public class LC695_MaxAreaOfIsland {
    public static void main(String[] args) {


        //char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] grid2 = new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};

        LC695_MaxAreaOfIsland lc695 = new LC695_MaxAreaOfIsland();
        //System.out.println(lc200.numIslands(grid));
        System.out.println(lc695.maxAreaOfIsland(grid2));


    }

    public int maxAreaOfIsland(char[][] grid) {

        int max = 0;
        if(grid == null || grid.length ==0){
            return 0;
        }


        for(int i=0;i< grid.length;i++){
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){

                    max = Math.max(max, dfs(grid, i,j));
                }

            }
        }


        return max;
    }

    private int dfs(char[][] grid, int i, int j) {

        if(i < 0 || i >= grid.length || j < 0 || j>= grid[i].length || grid[i][j] == '0' ){
            return 0;
        }

        grid[i][j] = '0';

        int count =1;
        count+=dfs(grid, i-1, j);
        count+=dfs(grid, i+1, j);
        count+=dfs(grid, i, j-1);
        count+=dfs(grid, i, j+1);

        return count;

    }

}
