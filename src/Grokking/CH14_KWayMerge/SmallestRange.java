package Grokking.CH14_KWayMerge;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
Given ‘M’ sorted arrays, find the smallest range that includes at least one number from each of the ‘M’ lists.

Example 1:

Input: L1=[1, 5, 8], L2=[4, 12], L3=[7, 8, 10]
Output: [4, 7]
Explanation: The range [4, 7] includes 5 from L1, 4 from L2 and 7 from L3.
Example 2:

Input: L1=[1, 9], L2=[4, 12], L3=[7, 10, 16]
Output: [9, 12]
Explanation: The range [9, 12] includes 9 from L1, 12 from L2 and 10 from L3.


*/
public class SmallestRange {
    public static int[] findSmallestRange(List<Integer[]> lists) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(n -> lists.get(n.arrayIndex)[n.elementIndex]));
        int rangeStart =0, rangeEnd = Integer.MAX_VALUE, currentMaxNum = Integer.MIN_VALUE;

        for (int i =0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                minHeap.add(new Node(0,i));
                currentMaxNum = Math.max(currentMaxNum, lists.get(i)[0]);
            }
        }

        while (minHeap.size() == lists.size()) {
            Node node = minHeap.poll();
            if(rangeEnd -rangeStart > currentMaxNum - lists.get(node.arrayIndex)[node.elementIndex]){
                rangeStart = lists.get(node.arrayIndex)[node.elementIndex];
                rangeEnd = currentMaxNum;
            }
            node.elementIndex++;
            if (lists.get(node.arrayIndex).length > node.elementIndex) {
                minHeap.add(node);
                currentMaxNum = Math.max(currentMaxNum, lists.get(node.arrayIndex)[node.elementIndex]);
            }
        }




        return new int[] {rangeStart, rangeEnd };
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 1, 5, 8 };
        Integer[] l2 = new Integer[] { 4, 12 };
        Integer[] l3 = new Integer[] { 7, 8, 10 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int[] result = SmallestRange.findSmallestRange(lists);
        System.out.print("Smallest range is: [" + result[0] + ", " + result[1] + "]");
    }

    static class Node{
        int elementIndex;
        int arrayIndex;

        public Node(int elementIndex, int arrayIndex) {
            this.elementIndex = elementIndex;
            this.arrayIndex = arrayIndex;
        }
    }
}
