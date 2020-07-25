package Grokking.CH13_TopKElements;

import java.util.ArrayList;
import java.util.List;

import java.util.*;

class Entry {
    int key;
    int value;

    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class KClosestElements {

    public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Entry> minHeap = new PriorityQueue<>((e1,e2)-> e1.value-e2.value);

        for(int i : arr){
            minHeap.add(new Entry(i, Math.abs(X-i)));
        }

        while(K > 0){
            result.add(minHeap.poll().key);
            K--;
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> result = KClosestElements.findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
        System.out.println("'K' closest numbers to 'X' are: " + result);

        result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
        System.out.println("'K' closest numbers to 'X' are: " + result);
    }
}
