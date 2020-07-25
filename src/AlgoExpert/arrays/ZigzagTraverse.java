package AlgoExpert.arrays;

import java.util.ArrayList;
import java.util.List;

public class ZigzagTraverse {
    public static void main(String[] args) {
        List<List<Integer>> array = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();

        arr.add(1);
        arr.add(3);
        arr.add(4);
        arr.add(10);
        array.add(arr);

        arr.add(2);
        arr.add(5);
        arr.add(9);
        arr.add(11);
        array.add(arr);

        arr.add(6);
        arr.add(8);
        arr.add(12);
        arr.add(15);
        array.add(arr);

        arr.add(7);
        arr.add(13);
        arr.add(14);
        arr.add(16);
        array.add(arr);


        zigzagTraverse(array).forEach(k-> System.out.print(k + " "));
    }

    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        // Write your code here.
        int height = array.size();
        int width = array.get(0).size();

        List<Integer> result = new ArrayList<>();
        int row = 0;
        int col = 0;


        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                result.add(array.get(0).get(0));
                //down
                if (!isInBounds(i+1, j, row, col)) {
                    //System.out.print(array.get(i-1).get(j) + " ");
                    result.add(array.get(i+1).get(0));

                }
            }

        }


        return result;
    }

    private static boolean isInBounds(int height, int width, int row, int col) {
        boolean inBounds = (row < 0 || row > height || col < 0 || col > width);
        return inBounds;
    }
}
