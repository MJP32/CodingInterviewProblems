package Leetcode.topic.stg;

public class LC1091_ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        System.out.println(new LC1091_ShortestPathInBinaryMatrix().shortestPathBinaryMatrix(
                new int[][]
                        {
                                {1,1,1,1},
                                {0,0,0,1},
                                {1,1,1,1}
                        }));
    }


    public int shortestPathBinaryMatrix(int[][] grid) {

        int min = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    int count = dfs(grid, i, j, m, n, new boolean[m][n]);

                    min = Math.max(min, count);
                }
            }
        }
        return min;
    }

    private int dfs(int[][] grid, int i, int j, int m, int n, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        int left = dfs(grid, i, j - 1, m, n, visited);
        int right = dfs(grid, i, j + 1, m, n, visited);
        int up = dfs(grid, i - 1, j, m, n, visited);
        int down = dfs(grid, i + 1, j, m, n, visited);
        visited[i][j] = false;

        return Math.min(left, Math.min(right, Math.min(up, down))) + grid[i][j];
    }
}
