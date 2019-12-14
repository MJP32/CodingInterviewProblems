package Leetcode;

public class LC253_MeetingRooms2 {
    public static void main(String[] args) {
        int[][]intervals = new int[][]{{0,30},{5,10},{15,20}};
        int[][]intervals2 = new int[][]{{0,10},{15,20},{25,30}};
        int[][]intervals3 = new int[][]{{1,2},{3,4},{5,6}};

        LC253_MeetingRooms2 lc253 = new LC253_MeetingRooms2();
        System.out.println(lc253.minMeetingRooms(intervals));
        System.out.println(lc253.minMeetingRooms(intervals2));
        System.out.println(lc253.minMeetingRooms(intervals3));

    }
    public int minMeetingRooms(int[][] intervals) {

        return 0;
    }

}
