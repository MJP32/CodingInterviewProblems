package bytebybyte.module3.hw;

public class SquareSubmatrix {
    public static void main(String[] args) {
        boolean[][] matrix = new boolean[][]{
                {false, true, true, true},
                {true, true, true, true},
                {false, true, true, true}
        };

//        boolean[][] matrix = new boolean[][]{
//                {false, true, false, false},
//                {true, true, true, true},
//                {false, true, true, false}
//        };


        System.out.println(squareSubmatrix(matrix));
    }

    static int squareSubmatrix(boolean[][] arr) {
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                max = Math.max(max, squareSubmatrix(arr, i, j));

            }

        }
        return max;
    }

    private static int squareSubmatrix(boolean[][] arr, int i, int j) {

        if (i == arr.length  || j == arr[0].length || !arr[i][j]) {
            return 0;
        }

        int result1 = squareSubmatrix(arr, i + 1, j);
        int result2 = squareSubmatrix(arr, i, j + 1);
        int result3 = squareSubmatrix(arr, i + 1, j + 1);
        return 1 + Math.min(result1, Math.min(result2, result3));
    }
}
