package Leetcode.topic.heap;

import java.util.PriorityQueue;

public class LC1167_MinimumCostToConnectSticks {
    public static void main(String[] args) {
        System.out.println(new LC1167_MinimumCostToConnectSticks().connectSticks(new int[]{2, 4, 3}));
    }

    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i : sticks) {
            minHeap.add(i);
        }
        int sum = 0;
        while (minHeap.size() > 1) {
            int cost = minHeap.poll() + minHeap.poll();
            sum += cost;
            minHeap.offer(cost);
        }

        return sum;

    }
}
