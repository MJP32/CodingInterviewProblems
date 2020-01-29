package Leetcode.zap.todo.finish;

import java.util.Arrays;

public class LC994_RottingOranges {
    public static void main(String[] args) {


        int[][] arr = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        int[][] arr2 = new int[][]{{2,1,1},{0,1,1},{1,0,1}};
        int[][] arr3 = new int[][]{{0,2}};

        System.out.println(new LC994_RottingOranges().orangesRotting(arr));
        System.out.println(new LC994_RottingOranges().orangesRotting(arr2));
        System.out.println(new LC994_RottingOranges().orangesRotting(arr3));

    }
    public int orangesRotting(int[][] grid) {




        int minutes =0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if(grid[i][j] ==2){
                    grid[i][j] = 3;
                    minutes += makeRotten(grid, i, j );
                }

            }

        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] ==1){
                    return -1;
                }
            }
        }

        //System.out.println(Arrays.deepToString(grid));

        return minutes;
    }

    private int makeRotten(int[][] grid, int i, int j) {
        int minutes =0 ;
      /* if(grid[0].length==1){
           System.out.println("here");
       }
        if(grid.length==1){
            System.out.println("here");
        }*/

//        System.out.println("->"+grid[0].length);
//        System.out.println("->"+grid.length);
//        System.out.println("->"+i);
//        System.out.println("->"+j);

        //right
        if (j < grid.length-1) {


            if (grid[i][j+1] == 1) {
                grid[i][j+1] =2;
                minutes++;
            }

        }

        //left
        if (j > 0 && grid[i][j-1] !=2) {


            if (grid[i][j-1] == 1) {
                grid[i][j-1] =2;
                minutes++;
            }

        }
        if(grid.length==1){
            return minutes;
        }

        //up
        if (i > 0 && grid[i-1][j] !=2) {


            if (grid[i-1][j] == 1) {
                grid[i-1][j] =2;
                minutes++;
            }

        }

        //down
        if ( i < grid[i].length-1) {


            if (grid[i+1][j] == 1) {
                grid[i+1][j] =2;
                minutes++;
            }

        }

            return minutes !=0 ?1:0;
    }
}
