package Pramp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KMeessedSort {
    public static void main(String[] args) {

        /**
         *  T O(n log(K))
         *  S O(k Else)
         *
         */
        System.out.println(Arrays.toString(sortKMessedArray(new int[]{1, 4, 5, 2, 3, 7, 8, 6, 10, 9}, 2)));
    }
    static int[] sortKMessedArray(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        if(arr.length == 0){
            return new int[0];
        }
        int temp = k;
        while(temp>=0){
            minHeap.add(arr[temp]);
            temp--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = minHeap.poll();
            if((i +k+1) < arr.length){
                minHeap.add(arr[i +k+1]);
            }
        }
        return arr;
    }
}
