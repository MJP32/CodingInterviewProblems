package bytebybyte.module2.hw;

import java.util.ArrayList;
import java.util.List;

public class Flatten2Darrayto1Darray {
    public static void main(String[] args) {
        flatten(new int[][]{{1,2,3},{4},{5,6}}).forEach(k-> System.out.println(k));
    }
    static List<Integer> flatten(int[][] arr){
        List<Integer> results = new ArrayList<>();
        flatten(arr, 0,0, results);
        return results;
    }

    private static void flatten(int[][] arr, int i, int j, List<Integer> result) {

        if(i == arr.length){
            return ;
        }
        if(j == arr[i].length){
            flatten(arr, i+1, 0, result);
            return;
        }
        result.add(arr[i][j]);
        flatten(arr, i, j+1, result);


    }
}
