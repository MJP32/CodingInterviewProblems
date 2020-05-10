package Leetcode.topic.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC57_InsertInterval {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new LC57_InsertInterval().insert(new int[][]{{1,3},{6,9}}, new int[]{2,5})));
        System.out.println(Arrays.deepToString(new LC57_InsertInterval().insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8})));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i =0;
        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));

        /*
        *  1, 2
        *  3, 5
        *  6, 7
        *  8, 10
        *  12, 16
        *
        *  4, 8
        *
        *
        *  3, 5
        *  6, 7
        *  8, 10
        *
        *
        *
        * */

        int newStart = newInterval[0];
        int newEnd = newInterval[1];


        while (i < intervals.length  && newStart > intervals[i][1]  ) {
            result.add(intervals[i++]);
        }

        while(i < intervals.length && intervals[i][0] <= newEnd){
            newStart = Math.min(newStart, intervals[i][0]);
            newEnd = Math.max(newEnd, intervals[i][1]);


            i++;
        }
        result.add(new int[]{newStart,newEnd});


        while (i < intervals.length ){
            result.add(intervals[i++]);
        }






        //result.forEach(k-> System.out.println(Arrays.toString(k)));


        return result.toArray(new int[result.size()][]);

    }
}
