package Leetcode.topic.stg.submit;

public class LC240_SearchA2dMatrix2 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println(new LC240_SearchA2dMatrix2().searchMatrix(matrix, 5));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        // 2-d binary search
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0){
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] > target) {
                col--;
            } else
                row++;
        }


        return false;
    }
}
