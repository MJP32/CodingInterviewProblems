package CapitalOne;

import java.util.Arrays;

public class TwoNumbersMinDiffRecursive2 {
    public static void main(String[] args) {
        int[] ints = new int[]{-10, -8, 9, -100, 200};
        Arrays.sort(ints);
        int min = new TwoNumbersMinDiffRecursive2().getMinDiff(ints,4);
        System.out.println(min);
    }

    private int getMinDiff(int[] array, int index) {
        int result;
        if (index==0){
            return Math.abs(array[index+1]+array[index]);
        }
        else {
            int diff = Math.abs((array[index]+array[index-1]));
            result = Math.min (diff, getMinDiff(array,index-1));
        }
        return result;
    }



}
