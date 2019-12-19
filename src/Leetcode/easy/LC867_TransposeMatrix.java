package Leetcode.easy;

import java.util.Arrays;

public class LC867_TransposeMatrix {
    public static void main(String[] args) {
        LC867_TransposeMatrix lc876 = new LC867_TransposeMatrix();

        int arr[][] = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

        System.out.println(Arrays.deepToString(lc876.transpose(arr)));
    }


    public int[][] transpose(int[][] A) {

        int result[][] = new int[A[0].length][A.length];

        if(A.length == 0){
            return result;
        }

        for(int i = 0; i < A[0].length; i++){
            for(int j = 0; j < A.length; j++){
                result[i][j] = A[j][i];
            }
        }

        return result;
    }
}
