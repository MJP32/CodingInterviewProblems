package Leetcode.pattern.dfs;

public class LC688_KnightProbabilityinChessboard {
    public static void main(String[] args) {
        System.out.println(new LC688_KnightProbabilityinChessboard().knightProbability(3, 2, 0, 0));
    }

    public double knightProbability(int N, int K, int r, int c) {
        if (r < 0 || c < 0 || r >= N || c >= N) {
            return 0;
        }
        if (K == 0) {
            return 1;
        }
        double leftUp = .125 * knightProbability(N, K - 1, r - 1, c - 2);
        double leftDown = .125 * knightProbability(N, K - 1, r + 1, c - 2);
        double downLeft = .125 * knightProbability(N, K - 1, r + 2, c - 1);
        double downRight = .125 * knightProbability(N, K - 1, r + 2, c + 1);

        double rightDown = .125 * knightProbability(N, K - 1, r + 1, c + 2);
        double rightUp = .125 * knightProbability(N, K - 1, r - 1, c + 2);
        double upRight = .125 * knightProbability(N, K - 1, r - 2, c + 1);
        double upLeft = .125 * knightProbability(N, K - 1, r - 2, c - 1);

        return leftUp+leftDown+downLeft+downRight+rightDown+rightUp+upRight+upLeft;

    }
}
