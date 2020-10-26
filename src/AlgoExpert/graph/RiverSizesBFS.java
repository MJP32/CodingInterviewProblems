package AlgoExpert.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RiverSizesBFS {
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
        // Write your code here.
        ArrayList<Integer> riverSizes = new ArrayList<>();
        for(int i=0; i< matrix.length;i++){
            for(int j =0; j < matrix[0].length;j++){
                if(matrix[i][j] == 1){
                    riverSizes.add(getRiverSizes(i, j, matrix));
                }
            }
        }
        return riverSizes;
    }

    private static int getRiverSizes(int i, int j, int[][] matrix){
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        int size = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i,j));
        matrix[i][j] = 0;
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int x = p.x;
            int y = p.y;
            for(int[] dir : directions){
                int newX = x + dir[0];
                int newY = y + dir[1];
                if(inBounds(newX, newY, matrix) && matrix[newX][newY]==1){
                    size++;
                    queue.add(new Pair(newX, newY));
                    matrix[newX][newY] = 0;
                }

            }
        }
        return size;

    }
    private static boolean inBounds(int i, int j, int[][] matrix){
        if(i >= 0 && j >=0 && i < matrix.length&& j < matrix[0].length ){
            return true;
        }
        return false;
    }
}
class Pair{
    int x;
    int y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

