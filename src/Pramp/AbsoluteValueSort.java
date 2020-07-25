package Pramp;

import java.util.Arrays;

public class AbsoluteValueSort {
    static int[] absSort(int[] arr) {
        // your code goes here

        //Arrays.sort(arr);


        for(int i =0;i < arr.length; i++){
            System.out.println(Arrays.toString(arr));
            for(int j=i+1; j< arr.length;j++){


                //if(arr[i] )

                if(Math.abs(arr[i]) >= Math.abs(arr[j])){
                    swap(arr, i, j);

                }
                else if(Math.abs(arr[i]) == Math.abs(arr[j])){

                    if(arr[j] <0){
                        swap(arr, i, j);
                    }

                }


            }
        }
        return arr;

    }


    public static void swap(int[] arr, int i, int j){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(absSort(new int[]{2, -7, -2, -2, 0})));
    }
}
