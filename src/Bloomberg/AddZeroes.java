package Bloomberg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AddZeroes {
    public static void main(String[] args) {
        //1,0,0,2,3,0,0,4
        int[] array = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        /*
         0 ,1
         1, 0
         2, 2
         3, 3
         4, 0
         5, 4
         6, 5
         7, 0


        */
        System.out.println(Arrays.toString(addZeroes(array)));
    }

    public static int[] addZeroes(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(i, array[i]);
        }
        map.forEach((k, v) -> System.out.println(k + ": " + v));
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                if (idx < array.length) {
                    array[idx++] = 0;
                }
                if (idx < array.length) {
                    array[idx++ ] = 0;
                }
            } else {
                if (idx < array.length) {
                    array[idx++] = entry.getValue();
                }
            }

        }

        return array;
    }
}
