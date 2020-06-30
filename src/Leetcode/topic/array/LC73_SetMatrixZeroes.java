package Leetcode.topic.array;

import java.util.Arrays;

public class LC73_SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,1,1},
                {1,0,1},
                {1,1,1}};

        int[][] matrix2 = new int[][]{
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}};

        int[][] matrix3 = new int[][]{
                {0,1}};
        new LC73_SetMatrixZeroes().setZeroes(matrix3);
        System.out.println(Arrays.deepToString(matrix3));
    }
    public void setZeroes(int[][] matrix) {

        int row=matrix.length;
        int col=matrix[0].length;

        //check if first row contain 0
        boolean rowHasZero=false;
        for(int i=0;i<col;i++)
        {
            if(matrix[0][i]==0)
            {
                rowHasZero=true;
                break;
            }

        }

        //check if first col contain zero
        for(int i=0;i<row;i++)
        {
            if(matrix[i][0]==0)
            {
                matrix[0][0]=0; //matrix[0][0] is for colHasZero...
                break;
            }
        }

        //setting the first row and first column cells to 0 if the corresponding cell in
        //matrix is 0
        for(int i=1;i<row;i++)
        {
            for(int j=1;j<col;j++)
            {
                if(matrix[i][j]==0)
                {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        //updating the cells,corresponding to first row 0's, equal to 0
        for(int i=1;i<col;i++)
        {
            if(matrix[0][i]==0)
            {
                for(int j=1;j<row;j++)
                {
                    matrix[j][i]=0;
                }
            }
        }

        //updating the cells,corresponding to first col 0's, equal to 0
        for(int i=1;i<row;i++)
        {
            if(matrix[i][0]==0)
            {
                for(int j=1;j<col;j++)
                {
                    matrix[i][j]=0;
                }
            }
        }

        //first col is filled first with 0 since the 0 in first row can set matrix[0][0] to
        // 0 which we had used as a flag for firstColZero...
        if(matrix[0][0]==0)
        {
            for(int i=1;i<row;i++)
            {
                matrix[i][0]=0;
            }
        }

        //now matrix[0][0] is of no use so update if first row contain zero
        if(rowHasZero)
        {
            for(int i=0;i<col;i++)
            {
                matrix[0][i]=0;
            }
        }





    }
}
