package Leetcode.topic.stg;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC994_RottingOranges {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{2,1,1},{1,1,0},{0,1,1}};

        System.out.println(new LC994_RottingOranges().orangesRotting(arr));

        System.out.println(Arrays.deepToString(arr));
    }

    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new LinkedList();
        int freshCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int time = 0;

        while (!q.isEmpty()) {
            time++;
            int size = q.size();

            while (size-- > 0) {
                int[] xy = q.poll();
                for (int[] d : direction) {
                    int x = xy[0] + d[0];
                    int y = xy[1] + d[1];
                    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }
                    q.add(new int[]{x, y});
                    grid[x][y] = 2;
                    freshCount--;
                }
            }
        }
        return freshCount == 0 ? time : -1;
    }
}



