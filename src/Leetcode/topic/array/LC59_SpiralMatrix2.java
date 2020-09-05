package Leetcode.topic.array;

import java.util.Arrays;

public class LC59_SpiralMatrix2 {
    public static void main(String[] args) {
        /*
        Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

        Example:

        Input: 3
        Output:
        [
         [ 1, 2, 3 ],
         [ 8, 9, 4 ],
         [ 7, 6, 5 ]
        ]

        */

        System.out.println(Arrays.deepToString(new LC59_SpiralMatrix2().generateMatrix(3)));
    }

    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];




       /* 0,0
        0,1
        0,2
        1,2
        2,2
        2,1
        2,0
        1,0
        1,1*/

        if (matrix.length == 0) {
            return matrix;
        }


        int rowBeg = 0;
        int rowEnd = matrix.length - 1;
        int colBeg = 0;
        int colEnd = matrix[0].length - 1;

        int count = 1;

        while (rowBeg <= rowEnd && colBeg <= colEnd) {

            for (int i = colBeg; i <= colEnd; i++) {
                matrix[rowBeg][i] = count++;
            }
            rowBeg++;

            for (int i = rowBeg; i <= rowEnd; i++) {
                matrix[i][colEnd] = count++;

            }

            colEnd--;

            if (rowBeg <= rowEnd) {
                for (int i = colEnd; i >= colBeg; i--) {
                    matrix[rowEnd][i] = count++;

                }
            }

            rowEnd--;

            if (colBeg <= colEnd) {
                for (int i = rowEnd; i >= rowBeg; i--) {
                    matrix[i][colBeg] = count++;
                }
            }

            colBeg++;


        }

        return matrix;
    }
}
