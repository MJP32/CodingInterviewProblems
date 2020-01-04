package Leetcode.easy;

import java.util.Arrays;

public class LC59_SpiralMatrix2 {
    public static void main(String[] args) {
        LC59_SpiralMatrix2  lc59 = new LC59_SpiralMatrix2();
        System.out.println(Arrays.deepToString(lc59.generateMatrix(3)));
        System.out.println(Arrays.deepToString(lc59.generateMatrix(4)));

    }

    public int[][] generateMatrix(int n) {

        int [][]res = new int[n][n];

        int rowBeg =0;
        int rowEnd = n-1;
        int colBeg =0;
        int colEnd =n-1;

        int num =1;

        while(rowBeg <=rowEnd && colBeg <= colEnd) {

            for (int i = colBeg; i <= colEnd; i++) {
                res[rowBeg][i] = num++;
            }

            rowBeg++;


            for (int i = rowBeg; i <= rowEnd; i++) {
                res[i][colEnd] = num++;
            }

            colEnd--;

            for (int i = colEnd; i >= colBeg; i--) {
                res[rowEnd][i] = num++;
            }

            rowEnd--;


            for (int i = rowEnd; i >= rowBeg; i--) {
                res[i][colBeg] = num++;
            }

            colBeg++;
        }


        return res;
    }
}
