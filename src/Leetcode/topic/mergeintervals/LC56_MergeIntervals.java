package Leetcode.topic.mergeintervals;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class LC56_MergeIntervals {
    public static void main(String[] args) {
        LC56_MergeIntervals lc56 = new LC56_MergeIntervals();
       // System.out.println(Arrays.deepToString(lc56.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})));
        System.out.println(Arrays.deepToString(lc56.merge(new int[][]{{1,4},{0,2},{3,5}})));
    }

    public int[][] merge(int[][] intervals) {

        if (intervals.length <1) {
            return null;
        }

        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));


        List<int[]> output = new ArrayList<>();
       int[] currInterval = intervals[0];
        output.add(currInterval);
        for (int[] interval :intervals){

            int currBegin = currInterval[0];
            int currEnd = currInterval[1];
            int nextBegin = interval[0];
           int nextEnd = interval[1];


           if (currEnd >= nextBegin) {
                currInterval[1] =  Math.max(currEnd, nextEnd);

           }
           else{
               currInterval = interval;
               output.add(currInterval);

           }

       }


       return output.toArray(new int[output.size()][]);

    }

}
