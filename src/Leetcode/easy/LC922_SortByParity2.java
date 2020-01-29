package Leetcode.easy;

import java.util.Arrays;

public class LC922_SortByParity2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LC922_SortByParity2().sortArrayByParity(new int[]{1,4, 4, 3, 0,3})));
    }

    public int[] sortArrayByParity(int[] A) {



        int[] arr = new int[A.length];

        int odd=1;
        int even =0;
        int counter =0;
        while(counter < A.length){

            if(A[counter] %2 ==0){
                arr[even] = A[counter];
                even+=2;
            }
            else
            {
                arr[odd] = A[counter];
                odd+=2;
            }
            counter++;


        }

        return arr;

    }
}
