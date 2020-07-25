package AlgoExpert.Search;


import java.util.Arrays;

public class QuickSelect {
    public static void main(String[] args) {
        System.out.println(quickselect(new int[]{8, 5, 2, 9, 7, 6, 3}, 3));
    }

    public static int quickselect(int[] array, int k) {
        // Write your code here.

        return quickselect(array, k, 0, array.length - 1);


    }

    private static int quickselect(int[] array, int k, int startIdx, int endIdx) {


        while (true) {

            if (startIdx > endIdx)
                return -1;

            int leftIdx = startIdx + 1;
            int pivotIdx = startIdx;
            int rightIdx = endIdx;

            while (leftIdx <= rightIdx) {

                if (array[leftIdx] > array[pivotIdx] && array[rightIdx] < array[pivotIdx]) {
                    swap(array, leftIdx, rightIdx);
                }

                if (array[leftIdx] <= array[pivotIdx]) {
                    leftIdx++;
                }
                if (array[rightIdx] >= array[pivotIdx]) {
                    rightIdx--;
                }


            }

            swap(array, pivotIdx, rightIdx);
            System.out.println(Arrays.toString(array));
            if (rightIdx == k - 1) {
                return array[rightIdx];
            } else if (rightIdx < k - 1) {
                startIdx = rightIdx + 1;
            } else {
                endIdx = rightIdx - 1;
            }

        }
    }

    public static void swap(int[] array, int leftIdx, int rightIdx) {
        int temp = array[leftIdx];
        array[leftIdx] = array[rightIdx];
        array[rightIdx] = temp;
    }
}
