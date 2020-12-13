package DailyByte;

import java.util.LinkedList;
import java.util.List;

public class MinPath {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 3},
                {2, 3, 1},
                {4, 6, 1}
        };

        System.out.println(greatestSumPath(grid));
    }
    static int minSum =Integer.MAX_VALUE;
    public static int greatestSumPath(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        result.add(Integer.MIN_VALUE);
        greatestSumPath(matrix, 0, 0,0, result);
        return minSum;

    }

    private static void greatestSumPath(int[][] matrix, int i, int j, int sum, List<Integer> result) {
        if (i >= matrix.length || j >= matrix[0].length)
            return;
        sum += matrix[i][j];

        if (i == matrix.length - 1 && j == matrix.length - 1) {
            if (minSum >  sum) {
               minSum = sum ;
                return;
            }
        }
        greatestSumPath(matrix, i+1, j, sum, result);
        greatestSumPath(matrix, i, j+1, sum, result);
    }

}
