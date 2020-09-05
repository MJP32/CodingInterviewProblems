package Grokking.CH13_TopKElements;

import java.util.*;

class Entry {
    int key;
    int value;
int sequence;

    public Entry(int key, int value, int sequence) {
        this.key = key;
        this.value = value;
        this.sequence = sequence;
    }
}

class KClosestElements {
static int sequence =0;
    public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {

        PriorityQueue<Entry> minHeap = new PriorityQueue<>((n1, n2) -> n1.key - n2.key);
        // add all candidate elements to the min heap, sorted by their absolute difference from 'X'
        for (int i = 0;i < arr.length; i++)
            minHeap.add(new Entry(Math.abs(arr[i] - X), i, sequence++));

        // we need the top 'K' elements having smallest difference from 'X'
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < K; i++)
            result.add(arr[minHeap.poll().value]);

        Collections.sort(result);
        return result;
    }



    public static void main(String[] args){
        List<Integer> result = KClosestElements.findClosestElements(new int[] { 0,0,1,2,3,3, 4,7,7,8 }, 3, 5);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
        System.out.println("'K' closest numbers to 'X' are: " + result);
    }

}


