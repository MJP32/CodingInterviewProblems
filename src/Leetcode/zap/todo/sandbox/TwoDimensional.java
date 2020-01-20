package Leetcode.zap.todo.sandbox;

import java.util.Arrays;

public class TwoDimensional {
    public static void main(String[] args) {
        TwoDimensional td = new TwoDimensional();
        System.out.println(Arrays.deepToString(td.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})));
        int[][] arr= new int[3][];





    }

    private int[][] merge(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(i+""+ j +" -> " + arr[i][j]);
            }
        }

        return arr;
    }

}
