package Leetcode.zap.todo.sandbox;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        //[[1,3],[2,6],[8,10],[15,18]]
        MergeIntervals mi = new MergeIntervals();
        System.out.println(Arrays.deepToString(mi.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})));

    }

    public int[][] merge(int[][] intervals) {

        if(intervals.length <=1){
            return intervals;
        }

        Arrays.sort(intervals, (arr1, arr2)-> Integer.compare(arr1[0],arr2[0]));


        List<int[]> output = new ArrayList<>();
        int[] currInterval = intervals[0];
        output.add(currInterval);



        for(int[] interval : intervals){

            int currBegin = currInterval[0];
            int currEnd = currInterval[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];



            if(currEnd >=nextBegin){
                currInterval[1] = Math.max(currEnd, nextEnd);
            }
            else{
                currInterval = interval;
                output.add(currInterval);

            }


            System.out.println("------");
            System.out.println(currBegin);
            System.out.println(currEnd);
            System.out.println(nextBegin);
            System.out.println(nextEnd);
        }




        return output.toArray(new int[output.size()][]);

    }
}
