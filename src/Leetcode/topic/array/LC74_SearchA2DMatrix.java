package Leetcode.topic.array;

public class LC74_SearchA2DMatrix {
    public static void main(String[] args) {
        System.out.println(new LC74_SearchA2DMatrix().searchMatrix(new int[][]{{1, 3, 5, 7
        }, {10, 11, 16, 20}, {23, 30, 34, 50}}, 3));
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        // 2-d binary search
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length, n = matrix[0].length;

        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] > target)
                right = mid - 1;
            else if (matrix[row][col] < target)
                left = mid + 1;
            else
                return true;
        }
        return false;
    }

}
