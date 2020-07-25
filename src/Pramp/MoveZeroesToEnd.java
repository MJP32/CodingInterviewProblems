package Pramp;

import java.util.Arrays;

public class MoveZeroesToEnd {
    static int[] moveZerosToEnd(int[] arr) {
        int[] arr2 = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != 0) {
                arr2[j] = arr[i];
                j++;
            }
        }
        return arr2;
    }

    static int[] moveZerosToEndSameArray(int[] arr) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0)
                arr[count++] = arr[i];
        }

        while(count < arr.length){
            arr[count++] =0;
        }

        return arr;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveZerosToEndSameArray(new int[]{1, 10, 0, 2, 8, 3, 0, 0, 6, 4, 0, 5, 7, 0})));
    }
}
