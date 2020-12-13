package Simon;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        quickSelect(new int[]{8, 5, 2, 9, 7, 6, 3}, 3);
    }
    public static int quickSelect(int[] array, int num){

       quickSelectHelper(array, 0, array.length-1);

        System.out.println(Arrays.toString(array));
       return array[num];
    }

    private static void quickSelectHelper(int[] array, int start, int end) {

        if(start >=end)
            return;;

        int pivot = start;
        int left = pivot +1;
        int right = end;

        while(left <= right){

            if(array[pivot] < array[left] && array[pivot] > array[right]){
                swap(array, left, right);

            }
            else if(array[pivot] >= array[left]){
                left++;
            }

            else if (array[pivot] <= array[right]){
                right--;
            }

        }

        swap(array, pivot, right);
        quickSelectHelper(array,start, right-1);
        quickSelectHelper(array,right+1, end );

    }


    private static void swap(int[] array, int left, int right) {
        int temp= array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
