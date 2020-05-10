package Leetcode.topic.mergeintervals;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC253_MeetingRooms2 {
    public static void main(String[] args) {

        int[][] intervals = new int[][]{{1, 10}, {2, 7}, {3, 19}, {8, 12}, {10, 20}, {11, 30}};

        System.out.println(new LC253_MeetingRooms2().minMeetingRooms(intervals));

    }

    public int minMeetingRooms(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(intervals.length, Comparator.comparingInt(z -> z));

        Arrays.sort(intervals, Comparator.comparingDouble(a -> a[0]));

        minHeap.add(intervals[0][1]);


        for (int i = 1; i < intervals.length; i++) {


            // If the room due to free up the earliest is free, assign that room to this meeting.
            // if next begins before previous meeting ends we need another room, add to heap, else remove bottom from heap
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }

            minHeap.add(intervals[i][1]);

        }

        return minHeap.size();


    }
}
