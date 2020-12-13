package CapitalOne;

public class TwoNumbersMinDiffRecursive {
    public static void main(String[] args) {
        int[] ints = new int[]{10, 7, -2, 6, 8, 2, -4, -4,  -27};
        int min = new TwoNumbersMinDiffRecursive().getMinDiff(ints);
        System.out.println(min);
    }

    private int getMinDiff(int[] ints) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ints.length - 1; i++) {
            min = Math.min(min, helper(i, i+ 1, ints, Integer.MAX_VALUE));
            System.out.println("->" + min);
        }
        return min;
    }

    //int global=0;
    private int helper(int first, int second, int[] arr, int min) {
        if (second == arr.length || first == arr.length) {
            return min;
        }
        min = Math.min(min, Math.abs(arr[first] + arr[second]));
        System.out.print(" " + min);
        return helper(first, second + 1, arr, min);
    }

}
