package CapitalOne;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        for (Integer key : map.keySet()) {
            maxHeap.add(new Pair(key, map.get(key)));
        }
        int[] result = new int[k];
        int i = 0;
        while (i < k && !maxHeap.isEmpty()) {
            result[i++] = maxHeap.poll().number;
        }
        return result;

    }

}
class Pair {
    int number;
    int freq;

    Pair(int n, int f) {
        this.number = n;
        this.freq = f;
    }
}
