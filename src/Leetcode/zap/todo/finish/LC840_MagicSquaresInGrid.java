package Leetcode.zap.todo.finish;

public class LC840_MagicSquaresInGrid {
    public static void main(String[] args) {


        LC840_MagicSquaresInGrid lc840 = new LC840_MagicSquaresInGrid();
        int [][] grid = new int[][]{{4,3,8,4},{9,5,1,9},{2,7,6,2}};

        System.out.println(lc840.numMagicSquaresInside(grid));

    }
    public int numMagicSquaresInside(int[][] grid) {
        //Assuming each row have the same length
        if(grid.length < 3 || grid[0].length < 3) return 0;

        int magicBoxCount = 0;
        for(int i=0; i<=(grid.length-3); i++){
            for(int j=0; (j<=grid[0].length-3); j++){
                if(isAMagicBox(grid, i, j))
                    magicBoxCount++;
            }
        }

        return magicBoxCount;
    }

    private boolean isAMagicBox(int[][] grid, int x, int y){
        if(grid[x+1][y+1] != 5) return false;

        //corner are even
        if(grid[x][y] %2 != 0 || grid[x+2][y] %2 != 0  ||
                grid[x][y+2] %2 != 0 || grid[x+2][y+2] %2 != 0 )
        {
            return false;
        }

        //not-corner are odd
        if(grid[x+1][y] %2 == 0 || grid[x][y+1] %2 == 0  ||
                grid[x+1][y+2] %2 == 0 || grid[x+2][y+1] %2 == 0 )
        {
            return false;
        }

        if ( (grid[x][y] + grid[x][y+1] + grid[x][y+2]) != 15 ||  //row1
                (grid[x+2][y] + grid[x+2][y+1] + grid[x+2][y+2]) != 15 ||  //row2
                (grid[x][y] + grid[x+1][y] + grid[x+2][y]) != 15) //column 1
        {
            return false;
        }

        return true;

    }

}
