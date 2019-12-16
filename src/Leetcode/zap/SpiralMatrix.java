package Leetcode.zap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

        System.out.println(Arrays.deepToString(matrix));
    }
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ls = new ArrayList<>();

       /* 0,0
        0,1
        0,2
        1,2
        2,2
        2,1
        2,0
        1,0
        1,1*/


        for(int i=0; i <matrix.length;i++){
            for (int j = 0; j < matrix[0].length; j++) {
                    ls.add(matrix[i][j]);

            }
        }
        return ls;
    }

}
