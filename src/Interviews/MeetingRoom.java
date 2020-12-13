package Interviews;

import java.util.*;

public class MeetingRoom{
    public static void main(String[] args){

        int[][] intervals = {{21,22},{1,4},{2,3},{4,6},{7,8},{9,10},{16,20},{15,18}};
        //answer = [[1,6],[7,8],[9,10],[15,20],[21,22]]

        List<int[]> list = minMeetingRooms(intervals);
        for(int[] l : list){
            System.out.println(Arrays.toString(l));
        }
    }
    public static List<int[]> minMeetingRooms(int[][] intervals) {

//        System.out.println(Arrays.deepToString(intervals));
        if(intervals == null || intervals.length ==0 ){
            return new ArrayList<>();
        }


//        Arrays.sort(intervals, Comparator.comparingInt(a ->a[0]));
//        System.out.println(Arrays.deepToString(intervals));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(intervals.length, Comparator.comparingInt(a->a[0]));

        for(int[] interval : intervals){
            minHeap.add(interval);
        }

        minHeap.forEach(k-> System.out.println(Arrays.toString(k)));
        List<int[]> result = new ArrayList<>();

        int[] curr= minHeap.poll();
        while(!minHeap.isEmpty()){

            int[] next = minHeap.poll();
            if(curr[1] >= next[0]){
                int start = Math.min(curr[0], next[0]);
                int end = Math.max(curr[1], next[1]);
//                minHeap.add(new int[]{start,end});
                curr[0] = start;
                curr[1] = end;
            }
            else{
                result.add(curr);
                curr = next;
            }


        }
        result.add(curr);

        /*
        for(int i =1; i < intervals.length;i++){

            if(intervals[i][0] >= minHeap.peek()[0]){
                minHeap.poll();
            }
            //minHeap.add(intervals[i][1]);
        }*/
        return result;


    }
}
class Meeting{
    int start;
    int end;
    public Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }
}