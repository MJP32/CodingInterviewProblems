package Leetcode.zap.todo.finish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC51_NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        Position[] positions = new Position[n];
        solve(0, positions, result, n);
        return result;
    }

    public void solve(int current, Position[] positions, List<List<String>> result, int n) {
        if (n == current) {
            StringBuffer buff = new StringBuffer();
            List<String> oneResult = new ArrayList<>();
            for (Position p : positions) {
                for (int i = 0; i < n; i++) {
                    if (p.col == i) {
                        buff.append("Q");
                    } else {
                        buff.append(".");
                    }
                }
                oneResult.add(buff.toString());
                buff = new StringBuffer();

            }
            result.add(oneResult);
            return;
        }

        for (int i = 0; i < n; i++) {
            boolean foundSafe = true;
            for (int j = 0; j < current; j++) {
                if (positions[j].col == i || positions[j].col - positions[j].row == i - current || positions[j].row + positions[j].col == i + current) {
                    foundSafe = false;
                    break;
                }
            }
            if (foundSafe) {
                positions[current] = new Position(current, i);
                solve(current + 1, positions, result, n);
            }
        }
    }

    public static void main(String args[]) {
        LC51_NQueens s = new LC51_NQueens();
        s.solveNQueens(4).forEach(k-> System.out.println(k));
    }

    class Position{
        int row, col;
        Position(int row, int col){
            this.row =row;
            this.col = col;
        }
    }

}


