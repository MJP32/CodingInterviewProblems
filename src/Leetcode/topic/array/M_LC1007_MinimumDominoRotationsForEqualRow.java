package Leetcode.topic.array;

public class M_LC1007_MinimumDominoRotationsForEqualRow {
    public static void main(String[] args) {

    }
    public int minDominoRotations(int[] A, int[] B) {
        int minSwaps = Math.min(
                numSwaps(A[0], A, B),
                numSwaps(B[0], A, B)
        );
        int minSwaps2 = Math.min(
                numSwaps(A[0], B, A),
                numSwaps(B[0], B, A)
        );
        int ans =Math.min(minSwaps,minSwaps2);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public int numSwaps(int target, int[] A, int[]B){
        int numSwaps =0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != target && B[i] != target) {
                return Integer.MAX_VALUE;
            }
            else if(A[i] != target){
                numSwaps++;
            }
        }
        return numSwaps;
    }
}
