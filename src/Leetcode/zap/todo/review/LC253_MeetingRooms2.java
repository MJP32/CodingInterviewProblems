package Leetcode.zap.todo.review;

import java.util.Arrays;

public class LC253_MeetingRooms2 {
    public static void main(String[] args) {

        LC253_MeetingRooms2 lc253 = new LC253_MeetingRooms2();
        System.out.println(lc253.minMeetingRooms(new int[][]{{0,30},{5,10},{15,20}}));
        System.out.println(lc253.minMeetingRooms(new int[][]{{7,10},{2,4}}));

    }

    public int minMeetingRooms(int[][] intervals) {


        int [] start = new int[intervals.length];
        int [] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals[i].length; j++) {

                start[i]= intervals[i][0];
                end[i]= intervals[i][1];
            }
        }

        Arrays.sort(start);
        Arrays.sort(end);

        System.out.println(Arrays.toString(start));
        System.out.println(Arrays.toString(end));

        int count=0;
        for (int i = 0; i < start.length-1; i++) {
            if(start[i+1]<end[i])
                count++;
        }


        return count;
    }
}
