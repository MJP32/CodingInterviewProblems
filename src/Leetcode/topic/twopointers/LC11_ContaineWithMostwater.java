package Leetcode.topic.twopointers;

public class LC11_ContaineWithMostwater {
    public static void main(String[] args) {
        /*
            Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
            n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
            Find two lines, which together with x-axis forms a container, such that the container contains the most water.

            Note: You may not slant the container and n is at least 2.

            Example:

            Input: [1,8,6,2,5,4,8,3,7]
            Output: 49

         */


        LC11_ContaineWithMostwater lc11 =new LC11_ContaineWithMostwater();
        System.out.println(lc11.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                int shortWall = Math.min(height[i],height[j]);
                max = Math.max(max,shortWall * (j-i));
            }
        }
        return max;
    }
}
