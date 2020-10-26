package Amazon.Mock;

import java.util.Arrays;

public class RIghtElementGreater {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new RIghtElementGreater().replaceElements(new int[]{17, 18, 5, 4, 6, 1})));
    }

    public int[] replaceElements(int[] arr) {
        int[] result = new int[arr.length];
        if (arr.length == 0) {
            return arr;
        } else if (arr.length == 1) {
            arr[0] = -1;
            return arr;
        }

        int max = arr[arr.length - 1];

        int oldVal = max;
        for (int i = arr.length - 1; i > 0; i--) {
            oldVal = arr[i - 1];
            arr[i - 1] = max;
            if (oldVal > max) {
                max = oldVal;
            }

        }
        arr[arr.length - 1] = -1;


        return arr;
    }
}
