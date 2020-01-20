package Leetcode.easy;

import java.util.Arrays;

public class LC905_SortArrayByParity {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LC905_SortArrayByParity().sortArrayByParity(new int[]{3,1,2,4})));
    }

    public int[] sortArrayByParity(int[] A) {



        int[] arr = new int[A.length];

        int i=0, j =A.length-1;
        int counter =0;
        while(counter < A.length){

            if(A[counter] %2 ==0){
                arr[i] = A[counter];
                i++;
            }
            else
            {
                arr[j] = A[counter];
                j--;
            }
            counter++;


        }

        return arr;

    }

}
