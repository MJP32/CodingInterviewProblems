package Leetcode.topic.heap;

import java.util.*;

public class LC347_TopKFrequentElements {
    public static void main(String[] args) {
        LC347_TopKFrequentElements lc347 = new LC347_TopKFrequentElements();
        lc347.topKFrequent(new int[]{1,1,1,2,2,3}, 2);
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();


        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }



        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue()-b.getValue());
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if(pq.size() > k) pq.poll();
        }

        //System.out.println(pq);


        List<Integer> res = new LinkedList<>();
        while(!pq.isEmpty()) {
            res.add(0, pq.poll().getKey());
        }


        res.forEach(p-> System.out.println(p));
        return res;
    }

    public int findKthLargest(List<Integer>nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(Integer i : nums) {
            minHeap.add(nums.get(i));
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }

        minHeap.forEach(p-> System.out.println(p));
        return minHeap.remove();
    }

}
