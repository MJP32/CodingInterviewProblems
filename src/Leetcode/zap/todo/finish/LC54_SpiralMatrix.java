package Leetcode.zap.todo.finish;

import java.util.ArrayList;
import java.util.List;

public class LC54_SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

        LC54_SpiralMatrix lc54 = new LC54_SpiralMatrix();
        lc54.spiralOrder(matrix).forEach(k-> System.out.println(k));
    }
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

       /* 0,0
        0,1
        0,2
        1,2
        2,2
        2,1
        2,0
        1,0
        1,1*/

       if(matrix.length == 0){
           return res;
       }


       int rowBeg =0;
       int rowEnd = matrix.length-1;
       int colBeg =0;
       int colEnd =matrix[0].length -1;

       while(rowBeg <=rowEnd && colBeg <= colEnd){

           for (int i = colBeg; i <= colEnd; i++) {
               res.add(matrix[rowBeg][i]);
           }
           rowBeg++;

           for (int i = rowBeg; i <= rowEnd; i++) {
               res.add(matrix[i][colEnd]);

           }

           colEnd--;

           if(rowBeg<=rowEnd){
               for (int i = colEnd; i >=colBeg ; i--) {
                   res.add(matrix[rowEnd][i]);

               }
           }

           rowEnd--;

            if(colBeg <= colEnd){
                for (int i = rowEnd; i >= rowBeg; i--) {
                    res.add(matrix[i][colBeg]);
                }
            }

            colBeg++;


       }

        return res;
    }

}
