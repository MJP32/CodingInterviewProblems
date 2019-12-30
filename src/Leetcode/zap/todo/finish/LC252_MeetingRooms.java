package Leetcode.zap.todo.finish;

import java.util.Arrays;

public class LC252_MeetingRooms {
    public static void main(String[] args) {
        int[][]intervals = new int[][]{{0,30},{5,10},{15,20}};
        int[][]intervals2 = new int[][]{{0,10},{15,20},{25,30}};
        int[][]intervals3 = new int[][]{{1,2},{3,4},{5,6}};

/*
        int[][] arr = { { 1, 2 }, { 3, 4 } ,{5, 6}};

        System.out.println("arr[0][0] = " + arr[0][0]);
        System.out.println("arr[0][1] = " + arr[0][1]);
        System.out.println("arr[1][0] = " + arr[1][0]);
        System.out.println("arr[1][1] = " + arr[1][1]);
        System.out.println("arr[2][0] = " + arr[2][0]);
        System.out.println("arr[2][1] = " + arr[2][1]);

        System.out.println("intervals3[0][0] = " + intervals3[0][0]);
        System.out.println("intervals3[1][0] = " + intervals3[1][0]);
        System.out.println("intervals3[2][0] = " + intervals3[2][0]);
        System.out.println("intervals3[0][1] = " + intervals3[0][1]);
        System.out.println("intervals3[1][1] = " + intervals3[1][1]);
        System.out.println("intervals3[2][1] = " + intervals3[2][1]);*/

        LC252_MeetingRooms lc252 = new LC252_MeetingRooms();
        System.out.println(lc252.canAttendMeetings(intervals));
        System.out.println(lc252.canAttendMeetings(intervals2));
        System.out.println(lc252.canAttendMeetings(intervals3));

    }

    public boolean canAttendMeetings(int[][] intervals) {
        int[]start = new int[intervals.length];
        int[]end = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals[i].length; j++) {

                start[i]    = intervals[i][0];
                end[i]    = intervals[i][1];
            }
        }

        Arrays.sort(start);
        Arrays.sort(end);

        for (int i = 0; i < start.length-1; i++) {
            if(start[i+1]<end[i])
                return false;
        }

        return  true;
    }
}

