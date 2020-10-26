package Leetcode.pattern.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class LC688_KnightProbabilityinChessboard {
    public static void main(String[] args) {
        System.out.println(new LC688_KnightProbabilityinChessboard().knightProbability(3, 2, 0, 0));
    }
/*
[[0.0, 0.0, 0.0], [0.0, 0.0, 0.125], [0.0, 0.125, 0.0]]
[[0.03125, 0.0, 0.015625], [0.0, 0.0, 0.0], [0.015625, 0.0, 0.0]]
0.0625
 */
    public double knightProbability(int N, int K, int r, int c) {
        if (r < 0 || c < 0 || r >= N || c >= N) {
            return 0;
        }
        double total = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        int[][] directions = {{1, 2}, {-1, 2}, {1, -2}, {-1, -2},
                {2, 1}, {2, -1}, {-2, 1}, {-2, -1},};
        double[][] board = new double[N][N];
        board[r][c] = 1;
        double multiplier = .125;
        while (K > 0) {
            int numInQueue = queue.size();
            while(numInQueue> 0) {
                int[] curPos = queue.poll();
                int x = curPos[0];
                int y = curPos[1];
                double prob = board[x][y];
                for (int[] dir : directions) {
                    Integer newX = x + dir[0];
                    Integer newY = y + dir[1];
                    if (inBounds(newX, newY, N)) {
                        if (board[newX][newY] == 0) {
                            queue.add(new int[]{newX, newY});
                        }
                        board[newX][newY] += prob * multiplier;
                    }
                }
                board[x][y] = 0;
                numInQueue--;
            }
            //System.out.println(Arrays.deepToString(board));
            K--;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                total += board[i][j];
            }
        }
        return total;
    }
    private boolean inBounds(int newX, int newY, int N) {
        return newX >= 0 && newY >= 0 && newX < N && newY < N ;
    }
}
