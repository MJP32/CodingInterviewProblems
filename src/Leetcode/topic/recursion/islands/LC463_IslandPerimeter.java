package Leetcode.topic.recursion.islands;

public class LC463_IslandPerimeter {
    public static void main(String[] args) {
        LC463_IslandPerimeter lc463 = new LC463_IslandPerimeter();


        int[][] arr = new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};


        System.out.println(lc463.islandPerimeter(arr));

    }

    public int islandPerimeter(int[][] grid) {


        int result =0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1){
                    result +=4;

                    result += hasNeighborLeftAbove(grid, i, j);
                    result += hasNeighborRightBelow(grid, i, j);
                }
            }
        }
        return result;
    }

    private int hasNeighborLeftAbove(int[][] grid, int i, int j) {

        return (i>0) && grid[i-1 ][j] == 1 ?-2:0;
    }

    private int hasNeighborRightBelow(int[][] grid, int i, int j) {
        return (j>0) && grid[i ][j-1] == 1 ?-2:0;

    }

}
