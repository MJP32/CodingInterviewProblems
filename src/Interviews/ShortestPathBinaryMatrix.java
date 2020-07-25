package Interviews;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    public static void main(String[] args) {

        /*
            Given Binary matrix, find the shortest path from top left to bottom right
            traversing through only the 0

        */


        int[][] grid = new int[][]{
                {0,1,1,1},
                {0,0,0,1},
                {0,1,1,0},
                {0,0,0,0}
        };

//        System.out.println(shortestCellPath(grid, 0,0,0,0));
        System.out.println(new ShortestPathBinaryMatrix().shortestPathBinaryMatrix(grid));
    }

    public  int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();

        int length = 0;
        queue.add(new Pair(0, 0));
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            length++;
            Queue<Pair<Integer, Integer>> newQueue = new LinkedList<>();

            while (!queue.isEmpty()) {
                Pair<Integer, Integer> cur = queue.poll();

                if (grid[cur.getKey()][cur.getValue()] == 1) {
                    continue;
                }

                if (cur.getKey() == n - 1 && cur.getValue() == m - 1) {
                    return length;
                }

                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int y = i + cur.getKey();
                        int x = j + cur.getValue();

                        if (y < 0 || y >= n || x < 0 || x >= m) {
                            continue;
                        }

                        if (visited[y][x]) {
                            continue;
                        }
                        visited[y][x] = true;

                        newQueue.add(new Pair(y, x));
                    }
                }
            }

            queue = newQueue;
        }

        return -1;
    }

    class Pair<T, V>{
        private int key;
        private int value;

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {

        int count =0;
        return dfs(count, grid, sr, sc, tr, tc);

    }
    public static int dfs(int count, int[][]grid, int starti, int startj, int endi, int endj){




        //check bounds

        if(starti < 0 ||starti > grid.length ||startj <0|| startj > grid[0].length || grid[starti][startj] != 1 ){
            return 0;
        }

    /* start (0,0)  end (2,0)
    [[1, 1, 1, 1],
     [0, 1, 0, 1],
     [1, 1, 1, 1]]
    */
        if (starti == endi && startj == endj) {
            return count;
        }
        int val = grid[starti][startj];
        grid[starti][startj] = 2;



        int result1 = dfs(count+1, grid, starti +1, startj, endi, endj  );
        int result2 = dfs(count+1, grid, starti -1, startj, endi, endj  );
        int result3 = dfs(count+1, grid, starti , startj+1, endi, endj  );
        int result4 = dfs(count+1, grid, starti , startj-1, endi, endj  );

        grid[starti][startj] = val;

        return Math.min(result1, Math.min(result2,Math.min(result3,result4)));


    }
}
