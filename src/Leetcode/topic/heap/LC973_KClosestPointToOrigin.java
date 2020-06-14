package Leetcode.topic.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

//sqrt((x2-x1)+(y2-y1))
public  class LC973_KClosestPointToOrigin {
    public static void main(String[] args) {
        LC973_KClosestPointToOrigin lc973 = new LC973_KClosestPointToOrigin();


        //sqrt((3-0)^2 +(1-0)^2)
        //sqrt(10)

        //sqrt((2-0)^2 +(-2-0)^2)
        //sqrt(8)



        System.out.println(Arrays.deepToString(lc973.kClosest(new int[][]{{1,3},{-2,2}}, 1)));
        System.out.println(Arrays.deepToString(lc973.kClosest(new int[][]{{3,3},{5,-1},{-2,4}}, 2)));
    }
    public int[][] kClosest(int[][] points, int K) {

        PriorityQueue<int[]> maxHeap  = new PriorityQueue<>((a, b) -> (b[0]*b[0] +b[1]*b[1]) - (a[0]* a[0] +a[1]*a[1]));


        for(int[] point : points) {
            maxHeap.add(point);
            while (maxHeap.size() > K) {

                maxHeap.remove();
            }
        }

        int[][] result = new int[K][2];

        while(K-- > 0 ){
            result[K] =  maxHeap.remove();
        }

        return result;
    }
}