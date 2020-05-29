package AlgoExpert.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraverse {
    public static void main(String[] args) {

        int[][] array= new int[][]{
                {1,2,3,4},
                {12,13,14,5},
                {11,16,15,6},
                {10,9,8,7}
        };

        spiralTraverse(array).forEach(k-> System.out.print(k + " "));
    }
    public static List<Integer> spiralTraverse(int[][] array) {

        int rowBeg = 0;
        int rowEnd = array.length-1;
        int colBeg = 0;
        int colEnd = array[0].length-1;

        List<Integer> result =new ArrayList<>();

        while(rowBeg <= rowEnd && colBeg<=colEnd) {

            for (int i = colBeg; i <= colEnd; i++) {
                result.add(array[rowBeg][i]);
            }

            rowBeg++;

            for (int i = rowBeg; i <= rowEnd; i++) {
                result.add(array[i][colEnd]);

            }

            colEnd--;

            if(rowBeg<=rowEnd){
                for(int i =colEnd; i >= colBeg;i--){
                    result.add(array[rowEnd][i]);
                }

            }
            rowEnd--;
            if (colBeg<=colEnd) {
                for(int i = rowEnd;i >=rowBeg;i--){
                    result.add(array[i][colBeg]);
                }
            }
            colBeg++;
            //for (int i>  )

        }
        return result;
    }
}
