package Leetcode.topic.recursion.islands;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC827_MakingALargeIsland {
    private int [][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) {

        int[][] grid = new int[][]{
                {0,1,0,1,0},
                {1,1,0,0,1},
                {0,0,1,1,0}};

         LC827_MakingALargeIsland lc200 = new LC827_MakingALargeIsland();
        //System.out.println(lc200.numIslands(grid));
        System.out.println(lc200.largestIsland(grid));


    }

    public int largestIsland(int[][] grid) {

        if(grid == null || grid.length ==0){
            return 0;
        }

        int max = 0, islandID =2;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i< grid.length;i++){
            for (int j = 0; j < grid[0].length; j++) {
               if(grid[i][j] == 1){

                   int size = getIslandSize(grid, i,j, islandID);

                   max = Math.max(max,size);
                   map.put(islandID++, size);
               }

            }
        }
        for(int i=0;i< grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] ==0) {
                    //unique islandIDs
                    Set<Integer> set = new HashSet<>();
                    for (int[] direction : directions) {
                        int x = direction[0] + i, y = direction[1] + j;
                        if (x > -1 && y > -1 && x < grid.length && y < grid[0].length && grid[x][y] != 0) {
                            set.add(grid[x][y]);
                        }
                    }
                    int sum =1;
                    for (int num : set) {
                        int value = map.get(num);
                        sum +=value;
                    }
                    max = Math.max(max, sum);
                }
            }
        }


        return max;
    }

    private int getIslandSize(int[][] grid, int i, int j, int islandID) {

        if(i < 0 || i >= grid.length || j < 0 || j>= grid[i].length || grid[i][j] != 1 ){
            return 0;
        }

        grid[i][j] = islandID;

        int up = getIslandSize(grid, i-1, j, islandID);
        int down  =getIslandSize(grid, i+1, j, islandID);
        int left = getIslandSize(grid, i, j-1, islandID);
        int right = getIslandSize(grid, i, j+1, islandID);

        return right + left + down +up + 1;
    }
}
