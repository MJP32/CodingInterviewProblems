package Leetcode.topic.dfs;

public class LC1219_PathWithMaximumGold {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        System.out.println(new LC1219_PathWithMaximumGold().getMaximumGold(grid));
    }

    public int getMaximumGold(int[][] grid) {

        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    int count = dfs(grid, i, j, m, n, new boolean[m][n]);

                    max = Math.max(max, count);
                }
            }
        }
        return max;
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

        return Math.max(left, Math.max(right, Math.max(up, down))) + grid[i][j];
    }
}
