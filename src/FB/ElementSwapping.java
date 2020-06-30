package FB;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ElementSwapping {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ElementSwapping().findMinArray(new int[]{5, 3, 1}, 2)));
        System.out.println(Arrays.toString(new ElementSwapping().findMinArray(new int[]{8, 9, 11, 2, 1}, 3)));
    }

    public int getSmallestNumber(int[] arr, int k) {
        int smallest = Integer.MAX_VALUE;
        while (k > 0) {
            smallest = Math.min(arr[k], smallest);
            k--;
        }
        return smallest;
    }

    int[] findMinArray(int[] arr, int k) {
        // Write your code here


        int index = -1;
        int min = Integer.MAX_VALUE;

        //while(k>0){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < k + 1; j++) {
                if (arr[j] < arr[i]) {
                    if (arr[j] < min) {
                        min = arr[j];
                        index = j;
                    }
                }
            }
        }
        while (index > 0 && k > 0) {
            int temp = arr[index];
            arr[index] = arr[index - 1];
            arr[index - 1] = temp;
            index--;
            k--;
            //return arr;
        }

        //k--;
        //}
        return arr;
    }

    private int getIndexOfSmallestElement(int[] arr, int k) {


        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

        for (Integer i : arr) {
            minHeap.add(arr[i]);
        }

        while (minHeap.size() >= 0) {

            for (int i = 0; i < k; i++) {
                if (minHeap.poll() == arr[i]) {
                    return i;
                }
            }
        }
        return -1;
    }

    private void swap(int[] arr, int i) {
    }
}
