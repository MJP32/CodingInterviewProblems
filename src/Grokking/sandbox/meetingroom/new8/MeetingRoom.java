package Grokking.sandbox.meetingroom.new8;


import java.util.*;

class Meeting {

    public int startTime;
    int endTime;

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public Meeting(int start, int end) {
        this.startTime = start;
        this.endTime = end;
    }


}



public class MeetingRoom {

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        if (intervals.length == 1) {
            return 1;
        }

        List<Meeting> meetingList = new ArrayList<>();
        for (int[] interval : intervals) {
            Meeting meeting = new Meeting(interval[0], interval[1]);
            meetingList.add(meeting);
        }
        Arrays.sort(intervals, Comparator.comparingDouble(a -> a[0]));




        PriorityQueue<Integer> minHeap= new PriorityQueue<>(intervals.length, Comparator.comparingInt(a -> a));

        minHeap.add(meetingList.get(0).endTime);
        for (int i = 1; i < meetingList.size(); i++) {
            Meeting meeting = meetingList.get(i);
            if(meeting.startTime < minHeap.peek()){
                minHeap.add(meeting.endTime);
            }else {
                minHeap.remove();
                minHeap.add(meeting.endTime);
            }
        }
        return minHeap.size();
    }

    public static void main(String[] args) {
        int[][] arr = {{2,3}, {2,9}, {4,10}, {11,17}};
        MeetingRoom meetingRoomNew = new MeetingRoom();
        System.out.println("Minimum numbers of meeting new rooms required are : "
                + meetingRoomNew.minMeetingRooms(arr));

    }

}