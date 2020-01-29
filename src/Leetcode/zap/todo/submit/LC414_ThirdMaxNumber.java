package Leetcode.zap.todo.submit;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LC414_ThirdMaxNumber {
    public static void main(String[] args) {
        //System.out.println(new LC414_ThirdMaxNumber().thirdMax(new int[]{3,2,1}));
        System.out.println(new LC414_ThirdMaxNumber().thirdMax(new int[]{2, 3,2,1}));
    }
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.contains(i)) {
                pq.offer(i);
                set.add(i);
                if (pq.size() > 3) {
                    set.remove(pq.poll());
                }
            }
        }
        if (pq.size() < 3) {
            while (pq.size() > 1) {
                pq.poll();
            }
        }
        return pq.peek();
    }



}
