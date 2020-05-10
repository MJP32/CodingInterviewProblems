package Leetcode.zap.todo.review.facebook;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC973_KClosetPointsToOrigin {

    public static void main(String[] args) {
        //System.out.println(Arrays.deepToString(new LC973_KClosetPointsToOrigin().kClosest(new int[][]{{1,3},{-2,2}}, 1)));
        System.out.println(Arrays.deepToString(new LC973_KClosetPointsToOrigin().kClosest(new int[][]{{3,3},{5,-1},{-2,4},{1,0}}, 2)));

    }
    public int[][] kClosest(int[][] points, int K) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));

        for(int[] point : points){
            maxHeap.add(point);

            if(maxHeap.size() >K){
                maxHeap.remove();
            }
        }

        int[][] result = new int[K][2];

        while (K-- >0) {
            result[K] = maxHeap.remove();
        }

        return result;
    }
}
