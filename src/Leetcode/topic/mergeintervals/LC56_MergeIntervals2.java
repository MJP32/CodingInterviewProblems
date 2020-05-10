package Leetcode.topic.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC56_MergeIntervals2 {
    public static void main(String[] args) {
        LC56_MergeIntervals2 lc56 = new LC56_MergeIntervals2();
//        System.out.println(Arrays.deepToString(lc56.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})));
//        System.out.println(Arrays.deepToString(lc56.merge(new int[][]{{1,3}})));
//        System.out.println(Arrays.deepToString(lc56.merge(new int[][]{{1,4},{5,6}})));
        System.out.println(Arrays.deepToString(lc56.merge(new int[][]{{1,4},{0,2},{3,5}})));


    }
    public int[][] merge(int[][] intervals) {


        if(intervals.length < 1 || intervals == null){
            return new int[0][];
        }

        List<int[]> mergedIntervals = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));


        if (intervals.length == 1) {
            return intervals;
        }

        int[] currInterval = intervals[0];
        mergedIntervals.add(currInterval);

        for(int[] interval : intervals){

            int nextBegin = interval[0];
            int nextEnd = interval[1];
            int currEnd = currInterval[1];

            if(currEnd >= nextBegin){

                currInterval[1] = Math.max(nextEnd, currEnd);
            }
            else{

                currInterval = interval;

                mergedIntervals.add(interval);
            }






        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);



    }

}
