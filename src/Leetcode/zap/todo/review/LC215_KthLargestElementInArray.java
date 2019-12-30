package Leetcode.zap.todo.review;

import java.util.PriorityQueue;

public class LC215_KthLargestElementInArray {
    public static void main(String[] args) {
        LC215_KthLargestElementInArray lc215 = new LC215_KthLargestElementInArray();
        System.out.println(lc215.findKthLargest(new int[]{3,2,1,5,6,4},2));
    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(Integer i : nums) {
            minHeap.add(nums[i]);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        return minHeap.remove();
    }

    //TODO: implement quick select

}
