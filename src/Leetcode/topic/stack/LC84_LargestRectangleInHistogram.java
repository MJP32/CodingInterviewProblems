package Leetcode.topic.stack;

import java.util.Stack;

public class LC84_LargestRectangleInHistogram {
    public static void main(String[] args) {
        System.out.println(new LC84_LargestRectangleInHistogram().largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea =0;
        int area =0;
        int i = 0;
        while ( i < heights.length) {
            if(stack.isEmpty() || heights[stack.peek()] <= heights[i]){
                stack.push(i++);
            }
            else{
                int top = stack.pop();
                if(stack.isEmpty()) {
                    area = heights[top] * i;
                }
                else {
                    area = heights[top] * (i - stack.peek()-1);


                }
                maxArea= Math.max(area, maxArea);
            }
        }

        while(!stack.isEmpty()){
            int top = stack.pop();
            if(stack.isEmpty()) {
                area = heights[top] * i;
            }
            else {
                area = heights[top] * (i - stack.peek()-1);
            }
            maxArea= Math.max(area, maxArea);

        }
        return maxArea;
    }

}
