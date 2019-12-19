package Leetcode.easy;

import java.util.PriorityQueue;

public class LC1046_LastStoneWeight {
    public static void main(String[] args) {
        LC1046_LastStoneWeight lc1046 = new LC1046_LastStoneWeight();
        System.out.println(lc1046.lastStoneWeight(new int[]{2,7,4,1,8,1}));
        System.out.println(lc1046.lastStoneWeight(new int[]{1}));
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap  = new PriorityQueue<>();
        for(int stone : stones){
            maxHeap.add(-stone);
        }

        while(maxHeap.size()>1){

            int stoneOne = -maxHeap.remove();
            int stonetwo = -maxHeap.remove();

            if(stoneOne!=stonetwo){
                maxHeap.add(-(stoneOne-stonetwo));

            }

        }

        return maxHeap.isEmpty()?0:-maxHeap.remove();
    }
}
