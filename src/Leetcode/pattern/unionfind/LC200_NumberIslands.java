package Leetcode.pattern.unionfind;

public class LC200_NumberIslands {

    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private UF uf;
    private int rows, cols, numIslands;

    public static void main(String[] args) {


        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        char[][] grid2 = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        LC200_NumberIslands lc200 = new LC200_NumberIslands();
        System.out.println(lc200.numIslands(grid));
//        System.out.println(lc200.numIslands(grid2));


    }

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }
        numIslands = 0;

        rows = grid.length;
        cols = grid[0].length;
        uf = new UF(rows * cols);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    unionAround(i, j, grid);
                }
            }
        }

        return numIslands;
    }

    private void unionAround(int i, int j, char[][] grid) {
        int cellIDCurrent = i * cols + j;
        for (int[] dir : directions) {
            int nx = i + dir[0];
            int ny = j + dir[1];
            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == '1') {

                int cellIdToCheck = nx * cols + ny;
                if (uf.union(cellIDCurrent, cellIdToCheck)) {
                    uf.print();
                    numIslands--;
                }
            }
        }
//        System.out.println("numIslands " + numIslands);
//        System.out.println(Arrays.toString(uf.parent));

    }

    class UF {
        int[] parent;

        public UF(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            System.out.println("orig");
            print();
        }

        private int find(int x) {
            if (parent[x] != x) {
                return parent[x] = find(parent[x]); // Path compression
            }
            return x;
        }

        // Return false if x and y are in the same disjoint set already
        public boolean union(int x, int y) {
            System.out.println("[" + x + ", " + y + "]");
            System.out.println("parent[x] " + parent[x]);
            System.out.println("parent[y] " + parent[y]);
            int parent1 = find(x);
            int parent2 = find(y);
            System.out.println("parentx " + parent1);
            System.out.println("parenty " + parent2);
            if (parent1 == parent2) {
                return false;
            }
            parent[parent1] = parent2;

            return true;
        }

        private void print() {
            for (int i = 0; i < parent.length; i++) {
                if (i % 5 == 0 && i != 0) {
                    System.out.println();
                }
                System.out.print(parent[i] + " ");
            }
            System.out.println("\n");
        }
    }

}
