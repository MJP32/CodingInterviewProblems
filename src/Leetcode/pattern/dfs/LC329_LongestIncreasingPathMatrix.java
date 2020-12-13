package Leetcode.pattern.dfs;

public class LC329_LongestIncreasingPathMatrix {
    private int [][] DIRECTIONS = {{1, 0}, {-1,0},{0,1},{0,-1}};

    public static void main(String[] args) {
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};

        System.out.println(new LC329_LongestIncreasingPathMatrix().longestIncreasingPath(matrix));
    }
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxPath = 0;
        int[][]cache = new int[n][m];
        for(int i =0; i < n; i++){
            for(int j=0; j< m;j++){
                int longest = longestIncreasingPath(matrix, cache, n,m,i,j);
                longest = Math.max(maxPath, longest);
            }
        }
        return maxPath;
    }
    public int longestIncreasingPath(int[][]matrix, int[][] cache, int n, int m, int i, int j){

        if(cache[i][j] > 0)
            return cache[i][j];
        int max = 0;
        for(int[] dir : DIRECTIONS){
            int x = dir[0] + i;
            int y = dir[1] + j;
            if(x > -1 && y > -1 && x< n && y< m && matrix[x][y] > matrix[i][j]){
                int longest = longestIncreasingPath(matrix, cache, n, m, x, y);
                max = Math.max(max, longest);
            }

        }
        cache[i][j] = max +1;
        return cache[i][j];
    }
}
