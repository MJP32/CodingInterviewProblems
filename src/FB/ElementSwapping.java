package FB;

import java.util.PriorityQueue;

public class ElementSwapping {
    public static void main(String[] args) {

    }

    int[] findMinArray(int[] arr, int k) {
        // Write your code here


        int index = -1;
        while(k >0){
            while (index != -1) {

                index = getIndexOfSmallestElement(arr, k );
            }

            if (index == -1) {
                return arr;
            }

            k = k-index;


        }


        return arr;
    }

    private int getIndexOfSmallestElement(int[] arr, int k) {


        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

        for (Integer i : arr) {
            minHeap.add(arr[i]);
        }

        while(minHeap.size() >=0){

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
