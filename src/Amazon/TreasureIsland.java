package Amazon;

import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland {
    int[][] directions = {{1, 0},{0, 1},{-1,0},{0,-1}};
    public static void main(String[] args) {
        char[][] grid = {
                {'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'O', 'O', 'O', 'O'},
                {'X', 'D', 'D', 'O'}

        };

        int minSteps =  new TreasureIsland().getTreasure(grid);
        System.out.println(minSteps);
    }

    private int getTreasure(char[][] grid) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0));
        grid[0][0] = 'D';
        int steps =0;


        while(!queue.isEmpty()){

            Point p = queue.poll();
            grid[p.x][p.y] = 'D';
            if(grid[p.y][p.x] == 'X'){
                return steps;
            }
            steps++;
            for(int[] dir: directions){
                int newX = p.x +dir[0];
                int newY = p.y +dir[1];
                if(isValid(newX, newY, grid)){
                    queue.add(new Point(newX, newY));
                }
            }
        }
        return -1;
    }

    private boolean isValid(int x, int y, char[][] grid ){
        if(x< grid.length && y < grid[0].length && x >=0 && y >=0 && grid[x][y] != 'D'){
            return true;
        }
        return false;
    }

    class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
