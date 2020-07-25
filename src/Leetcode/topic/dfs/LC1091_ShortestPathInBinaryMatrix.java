package Leetcode.topic.dfs;

public class LC1091_ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        System.out.println(new LC1091_ShortestPathInBinaryMatrix().shortestCellPath(
                new int[][]
                        {
                                {1, 1, 1, 1},
                                {1, 0, 0, 1},
                                {1, 1, 1, 1}
                        }));
    }

    public int shortestCellPath(int[][] grid) {


        int count = dfs(grid, 0, 0, grid.length-1, grid[0].length-1, new boolean[grid[0].length][grid.length]);

        int min = 0;
        min =Math.min(min, count);

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

        return Math.min(left, Math.min(right, Math.min(up, down)));
    }
}
