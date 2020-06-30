package Leetcode.topic.stack;

import java.util.Arrays;
import java.util.Stack;

public class LC85_MaximalRectangle {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '0'}};

        System.out.println(new LC85_MaximalRectangle().maximalRectangle(board));
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[] counts = new int[matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {

            counts[i] = matrix[0][i] - '0';
        }
        int maxArea = getMaxArea(counts);
        Arrays.fill(counts, 0);

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != '0') {
                    counts[j] = matrix[i - 1][j] - '0' + matrix[i][j] - '0';
                    matrix[i][j] = (char) (counts[j] + 48);
                } else {
                    counts[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, getMaxArea(counts));
        }


        return maxArea;
    }

    private int getMaxArea(int[] counts) {
        System.out.println(Arrays.toString(counts));

        int maxArea = 0;
        int i = 0;
        int area = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < counts.length) {
            if (stack.isEmpty() || counts[stack.peek()] <= counts[i]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    area = counts[top] * i;
                } else {
                    area = counts[top]  * (i-stack.peek() - 1);
                }
                maxArea = Math.max(area, maxArea);
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (stack.isEmpty()) {
                area = counts[top] * i;
            } else {
                area = counts[top]  * (i-stack.peek() - 1);
            }
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
