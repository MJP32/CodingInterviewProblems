package AlgoExpert.graph;

import java.util.ArrayList;

public class RiverSizes {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,0,0,1,0},
                {1,0,1,0,0},
                {0,0,1,0,1},
                {1,0,1,0,1},
                {1,0,1,1,0}};

        riverSizes(matrix).forEach(k-> System.out.println(k));

    }
    public static ArrayList<Integer> riverSizes(int[][] matrix) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if(matrix[i][j] == 1){
                    list.add(dfs(matrix, i, j));

                }
            }

        }
        return list;
    }

    private static int dfs(int[][] grid, int i, int j) {

        if(i < 0 || i >= grid.length || j < 0 || j>= grid[i].length || grid[i][j] == 0 ){
            return 0;
        }

        grid[i][j] = 0;

        int count =1;
        count+=dfs(grid, i-1, j);
        count+=dfs(grid, i+1, j);
        count+=dfs(grid, i, j-1);
        count+=dfs(grid, i, j+1);

        return count;

    }

}
