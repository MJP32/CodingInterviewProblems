package Interviews;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    private static int[][] DIRECTIONS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static void main(String[] args) {

        /*
            Given Binary matrix, find the shortest path from top left to bottom right
            traversing through only the 0


            Input =

        */


        int[][] grid = new int[][]{
                {0, 1, 1, 1},
                {0, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };

        int[][] grid2 = new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };

        System.out.println(new ShortestPathBinaryMatrix().shortestPathBinaryMatrix(grid));
        System.out.println(new ShortestPathBinaryMatrix().shortestPathBinaryMatrix(grid2));
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1)
            return -1;
        queue.add(new int[]{0, 0});
        visited[0][0] = true;


        int steps = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (curr[0] == grid.length - 1 && curr[1] == grid[0].length - 1)
                    return steps + 1;

                for (int[] dir : DIRECTIONS) {
                    int newX = curr[0] + dir[0], newY = curr[1] + dir[1];
                    if (outOfBounds(newX, newY, grid) || visited[newX][newY] || grid[newX][newY] == 1)
                        continue;
                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
            steps++;
        }

        return -1;
    }

    private boolean outOfBounds(int x, int y, int[][] grid) {
        return x < 0 || x >= grid.length || y < 0 || y >= grid[0].length;
    }
}
