package AlgoExpert.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(quickSort(new int[]{8,5,2,9,5,6,3})));
    }

    private static int[] quickSort(int[] array) {
        quickSort(array, 0, array.length-1);
        return array;
    }

    private static void quickSort(int[] array, int startIdx, int endIdx) {
        if(startIdx >= endIdx){
            return;
        }
        int pivotIdx = startIdx;
        int leftIdx = startIdx +1;
        int rightIdx = endIdx;

        while(leftIdx <=rightIdx){
            if(array[leftIdx] > array[pivotIdx] && array[rightIdx] < array[pivotIdx]){
                swap(leftIdx, rightIdx, array);
            }
            if (array[leftIdx]<= array[pivotIdx]) {
                leftIdx++;
            }
            if(array[rightIdx] >=array[pivotIdx]){
                rightIdx--;
            }
        }

        swap(pivotIdx, rightIdx, array);
        quickSort(array,startIdx , rightIdx-1 );
        quickSort(array, rightIdx+1, endIdx);
    }

    private static void swap(int pivotIdx, int rightIdx, int[] array) {
        int temp = array[rightIdx];
        array[rightIdx] = array[pivotIdx];
        array[pivotIdx] = temp;
    }

}
