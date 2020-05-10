package Leetcode.topic.mergeintervals;



import Grokking.Ch4_MergeIntervals.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC986_IntervalListIntersections {
    public static void main(String[] args) {

//        int[][] input1 = new int[][] { {1, 3}, {5, 6}, {7, 9} };
//        int[][] input2 = new int[][] { {2, 3}, {5, 7} };
        int[][] input1 = new int[][] { {0, 2}, {5, 10}, {13, 23}, {24, 25} };
        int[][] input2 = new int[][] { {1, 5}, {8, 12}, {15, 24}, {25, 26} };
        int[][] result = LC986_IntervalListIntersections.intervalIntersection(input1, input2);
        System.out.print(" Intersection: ");
            System.out.print(Arrays.deepToString(result));

    }
    public static int[][] intervalIntersection(int[][] A, int[][] B) {

        List<int[]> intersected = new ArrayList<>();


        int i =0;
        int j =0;

        while (i < A.length && j < B.length) {

            if(A[i][0]  >= B[j][0]  && A[i][0] <=B[j][1] || B[j][0] >= A[i][0] && B[j][0] <=A[i][1]  ){
                int max = Math.min(A[i][1], B[j][1]);
                int min =Math.max(A[i][0], B[j][0]);
                intersected.add(new int[]{min,max });

            }


            if (A[i][1] < B[j][1]) {
                i++;
            }
            else{
                j++;
            }

        }




        return intersected.toArray(new int[intersected.size()][]);
    }
}
