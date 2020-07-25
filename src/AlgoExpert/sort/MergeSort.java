package AlgoExpert.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSort(new int[]{1,5,6,2,3,7})));
    }
    public static int[] mergeSort(int[] array) {
        // Write your code here.

        if(array.length <=1){
            return array;
        }
        int middleIndex = array.length/2;

        int[] left = Arrays.copyOfRange(array, 0, middleIndex);
        int[] right = Arrays.copyOfRange(array,middleIndex, array.length);
        return mergeSortedArrays(mergeSort(left), mergeSort(right));



    }

    public static int[] mergeSortedArrays(int[] leftHalf, int[] rightHalf){
        int[] mergedArray = new int[leftHalf.length + rightHalf.length];
        int i =0;
        int j =0;
        int k =0;
        while(i < leftHalf.length && j < rightHalf.length){
            if(leftHalf[i] <= rightHalf[j]){
                mergedArray[k++] = leftHalf[i++];
            }
            else{
                mergedArray[k++] = rightHalf[j++];
            }
        }
        while(i < leftHalf.length){
            mergedArray[k++] = leftHalf[i++];
        }
        while(j < rightHalf.length){
            mergedArray[k++] = rightHalf[j++];

        }
        return mergedArray;
    }




}

