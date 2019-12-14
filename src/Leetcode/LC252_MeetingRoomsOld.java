package Leetcode;


import java.util.Arrays;

public class LC252_MeetingRoomsOld {
    public static void main(String[] args) {
        Intervals[] intervals = new Intervals[3];
        intervals[0] = new Intervals(0, 30);
        intervals[1] = new Intervals(5, 10);
        intervals[2] = new Intervals(15, 20);

        Intervals[] intervals2 = new Intervals[3];
        intervals2[0] = new Intervals(0, 10);
        intervals2[1] = new Intervals(15, 20);
        intervals2[2] = new Intervals(25, 30);


        LC252_MeetingRoomsOld lc252 = new LC252_MeetingRoomsOld();


        //System.out.println(lc252.canAttendMeetings(intervals));
        System.out.println(lc252.canAttendMeetings(intervals2));

    }
    public boolean canAttendMeetings(Intervals[] intervals) {

        int[] starts = new int[intervals.length];
        int[] end = new int[intervals.length];


        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }

        Arrays.sort(starts);
        Arrays.sort(end);


        for (int i = 0; i <starts.length-1; i++) {
            if(starts[i+1] < end[i])
                return false;

        }
        return true;


    }
}
class Intervals{
    int start;
    int end;

    public Intervals(int s, int e) {
        start = s;
        end = e;
    }

    public Intervals() {
        start =0;
        end =0;
    }
}