package Interviews.InterviewIO;

import java.util.HashMap;

public class PascalTriangle {
    public static void main(String[] args) {

        /*
                    1
                   1 1
                  1 2 1
                 1 3 3 1
                1 4 *6 4 1
              1 5 10 10 5 1

               4,2 -> 3,1 -> 2,0 -> 1
                          -> 2,1 -> 1,0 -> 1
                                 -> 1,1 -> 1
                   -> 3,2 -> 2,1 -> 1,0 -> 1
                                 -> 1,1 -> 1
                             2,2 -> 1

        */


//        System.out.println(getNum(2, 1));
        HashMap<String, Integer> map = new HashMap<>(   );
        int[][] cache = new int [2][5000];
        System.out.println(getNum(5000, 2, cache));
//        System.out.println(getNum(2,1));
//        System.out.println(getNum(2,1));

        //print(6);
    }

    public static int getNum(int row, int col, int[][] cache) {
       //System.out.println(row + ", " + col);



        if (col == 0 || col == row) {
            System.out.println();
            return 1;
        }
        //String id = row + ", " + col;
        if(cache[col-1][row-1] != 0){
            return cache[col-1][row-1];
        }


        int sum = getNum(row - 1, col - 1, cache) + getNum(row - 1, col, cache);
        //cache[col-1][row-1] = sum;
        return sum;
    }

    public static void print(int n) {
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n - i; k++) {
                System.out.print(" "); // print space for triangle like structure
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(pascal(i, j) + " ");
            }
            System.out.println();
        }
    }

    public static int pascal(int i, int j) {
        if (j == 0 || j == i) {
            return 1;
        } else {
            return pascal(i - 1, j - 1) + pascal(i - 1, j);
        }
    }

}
