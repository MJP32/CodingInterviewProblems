package Leetcode.zap.todo.review.facebook;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC415_AddStrings {
    public static void main(String[] args) {
        System.out.println(new LC415_AddStrings().addStrings("1234", "1234" ));
    }
    public String addStrings(String num1, String num2) {

        StringBuilder sb = new StringBuilder();
        int i = num1.length()-1;
        int j = num2.length()-1;
        int sum = 0;
        int carry = 0;
        while (i >=0 ||j >=0) {
            sum +=carry;
            carry =0;

            if (i>=0) {
               sum += num1.charAt(i--) - '0';
            }
            if (j>=0) {
                sum += num2.charAt(j--) - '0';
            }
            sb.append(sum %10);
            carry = sum/10;
            sum =0;
        }
        return sb.reverse().toString();
    }

    //sqrt((x2-x1)+(y2-y1))
    public static class LC973_KCLosetPointToOrigin {
        public static void main(String[] args) {
            LC973_KCLosetPointToOrigin lc973 = new LC973_KCLosetPointToOrigin();


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
}
