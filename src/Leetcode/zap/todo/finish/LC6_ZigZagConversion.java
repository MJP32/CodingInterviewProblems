package Leetcode.zap.todo.finish;

import java.util.Arrays;

public class LC6_ZigZagConversion {

    public static void main(String[] args) {

        LC6_ZigZagConversion lc6 = new LC6_ZigZagConversion();


        int numRows = 3;
        String s = "MICHAEL";
        String s1 = "PAYPALISHIRING";

        System.out.println(lc6.convert(s1, numRows));


    }

    public String convert(String s, int numRows) {
        char[][] arr = new char[numRows][s.length()];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                arr[i][j] =' ';
            }
        }

        int start = 0;
        int end = numRows - 1;

        int col = 0;
        int colAcross = 0;
        int offset = 1;

        StringBuilder sb = new StringBuilder();
        while (start <= s.length()) {


            placeDown(start, end, arr, s, numRows, col, sb);


            start += numRows;
            end += numRows;
            placeAcross(start, end, arr, s, numRows, colAcross, offset, sb);
            col += numRows - 1;
            offset += numRows - 1;
            start += numRows - 2;
        }
        //System.out.println(Arrays.deepToString(arr));
        String str = print2Darray(arr);
        return str;
    }

    private void placeAcross(int start, int end, char[][] arr, String s, int numRows, int col, int offset, StringBuilder sb) {
        int index = numRows - 1;

        if(s.length() -start < numRows){
            numRows =s.length() -start;
        }


        for (int i = numRows - 2; i > 0; i--) {
            arr[col + i][offset] = s.charAt(start);

            sb.append(s.charAt(start));
        }
    }

    private void placeDown(int start, int end, char[][] arr, String s, int numRows, int col, StringBuilder sb) {

        if(s.length() -start < numRows){
            numRows =s.length() -start;
        }

        for (int i = 0; i < numRows; i++) {
            arr[i][col] = s.charAt(i + start);
            sb.append(s.charAt(i + start));
        }

    }

    private String print2Darray(char[][] arr) {
        String result ="";
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                if(arr[i][j] !=' ')
                    result +=  arr[i][j];
            }
            //System.out.println();
        }

        return result;
    }

}
