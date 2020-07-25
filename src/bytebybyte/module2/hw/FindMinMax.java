package bytebybyte.module2.hw;

import java.util.Arrays;

public class FindMinMax {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(minMax(new int[]{1,2,3,4,5,6,7,8,9,10,11})));
    }
    static int[] minMax(int[] arr){
        return minMax(arr, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, new int[2]);
    }

    private static int[] minMax(int[] arr, int i, int min, int max, int[] result) {

        if(i==arr.length){
            return result;
        }

        min = Math.min(min, arr[i]);
        max = Math.max(max, arr[i]);

        result[0] = min;
        result[1] = max;

        return minMax(arr, i+1, min, max, result);
    }
}
