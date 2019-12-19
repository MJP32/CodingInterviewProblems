package Leetcode.medium;

import java.util.Arrays;

public class LC48_RotateImage {
    public static void main(String[] args) {
        LC48_RotateImage lc48 = new LC48_RotateImage();
        int arr[][] = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        lc48.rotate(arr);
    }

    public void rotate(int[][] matrix) {

        int N = matrix.length;

        for (int i = 0; i < N; i++) {
            for (int j = i; j <N ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }

        }

        for(int[] x: matrix)
            System.out.println(Arrays.toString(x));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <N/2 ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }

        }
        for(int[] x: matrix)
            System.out.println(Arrays.toString(x));



    }
}
