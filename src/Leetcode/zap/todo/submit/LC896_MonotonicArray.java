package Leetcode.zap.todo.submit;

public class LC896_MonotonicArray {
    public static void main(String[] args) {
        LC896_MonotonicArray lc896 = new LC896_MonotonicArray();

        System.out.println(lc896.isMonotonic(new int[]{1,2,2,3}));
        System.out.println(lc896.isMonotonic(new int[]{1,3,2}));
        System.out.println(lc896.isMonotonic(new int[]{6,5,4,4}));
    }

    public boolean isMonotonic(int[] A) {
        if(A.length ==1){
            return true;
        }
        boolean inc = true;
        boolean dec = true;
        for (int i = 0; i < A.length - 1; i++) {
            if(A[i] >A[i+1]){
                inc =  false;
            }
            if(A[i] <A[i+1]){
                dec =  false;
            }
        }
        return (inc || dec);
    }
}
