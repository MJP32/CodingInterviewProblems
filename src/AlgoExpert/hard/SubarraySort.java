package AlgoExpert.hard;

import java.util.Arrays;

public class SubarraySort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(subarraySort(new int[]{1,2,4,7,10,11,7,12,6,7,16,18,19})));
    }
    public static int[] subarraySort(int[] array) {
        // Write your code here.

        int left = 0;
        int right = array.length - 1;

        int[] result = new int[2];
        while (left < array.length-1) {

            if(array[left] > array[left+1]){
                break;
            }

            left++;
        }
        while (right>0 ) {
            if (array[right] < array[right-1]) {
                break;
            }
            right--;
        }

        //System.out.println(array[left+1] + " "+array[right-1]);

        int leftPivot = left+1;
        int rightPivot = right-1;
        for (int i = 0; i < array.length; i++) {


            if(array[i] >= array[leftPivot]){
                result[0] =i;
                break;
            }
        }
        for (int i = array.length-1; i >=0 ; i--) {
            if(array[i]<= array[rightPivot]){
                result[1] = i;
                break;
            }
        }

        return result;
    }
}
