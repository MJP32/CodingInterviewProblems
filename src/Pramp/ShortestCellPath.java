package Pramp;

public class ShortestCellPath {
    public static void main(String[] args) {
        System.out.println(shortestCellPath(
                new int[][]
                        {
                                {1,1,1,1},
                                {1,0,0,1},
                                {1,1,1,1}
                                }, 0,0,2,0));
    }

    static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
        // your code goes here

        //for(int i =; i < grid.length();i++){
        //for(int j=0; j < grid[0].length;j++){
        //if(grid[i][j] == 1){

        //}
        // }
        //}
        int count =0;
        int minDist =Integer.MAX_VALUE;
        return dfs(count, minDist, grid, sr, sc, tr, tc);

    }
    public static int dfs(int count, int minDist, int[][]grid, int starti, int startj, int endi, int endj){




        //check bounds

        if(starti < 0 ||starti >= grid.length || startj <0|| startj >= grid[0].length || grid[starti][startj] != 1 ){
            return 0;
        }

    /* start (0,0)  end (2,0)
    [[1, 1, 1, 1],
     [0, 1, 0, 1],
     [1, 1, 1, 1]]
    */
        if (starti == endi && startj == endj) {
            return Math.min(count, minDist);
        }
        int val = grid[starti][startj];
        grid[starti][startj] = 0;

        //right
        minDist += dfs(count+1, minDist, grid, starti , startj+1, endi, endj  );

        //down
        minDist += dfs(count+1, minDist, grid,  starti +1, startj, endi, endj  );
        //int result2 = dfs(count+1, grid, starti -1, startj, endi, endj  );
        //int result4 = dfs(count+1, grid, starti , startj-1, endi, endj  );

        grid[starti][startj] = val;

        //return Math.min(result1, Math.min(result2,Math.min(result3,result4)));

//return Math.min(result1, result3);
        return minDist;
    }







}
