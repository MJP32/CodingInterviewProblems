package AlgoExpert.arrays;

import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {
    public static void main(String[] args) {
        moveElementToEnd(Arrays.asList(2, 1, 2,2,2, 3,4,2), 2).forEach(k-> System.out.print(k));
    }
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int left =0;
        int right = array.size()-1;
        while(left<right){
            while(left< right && array.get(right) == toMove){
                right--;
            }
            if(array.get(left) == toMove)
                swap(array, left, right);

            left++;
        }


        return array;
    }

    public static void swap(List<Integer> array, int i , int j ){
        int temp = array.get(j);
        array.set(j, array.get(i));
        array.set(i, temp);


    }
}
