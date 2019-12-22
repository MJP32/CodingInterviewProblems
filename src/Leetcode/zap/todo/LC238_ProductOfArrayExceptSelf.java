package Leetcode.zap.todo;

public class LC238_ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        LC238_ProductOfArrayExceptSelf lc238 = new LC238_ProductOfArrayExceptSelf();
        int[]res = lc238.productExceptSelf(new int[]{1,2,3,4});

        for(Integer i: res){
            System.out.print(i +" ");
        }
    }

    public int[] productExceptSelf(int[] nums) {
        int results = 0;

        int N = nums.length;

        int[] outputArr = new int[N];
        int[] L = new int[N];
        int[] R = new int[N];

        outputArr[0] =1;
        L[0] =1;
        R[N-1] =1;
        for (int i = 1; i < nums.length; i++) {
            L[i] = nums[i-1]*L[i-1];
        }

        for(int i=nums.length-2;i>=0;i--){
            R[i] =nums[i+1]*R[i+1];
        }

        for (int i = 0; i < nums.length; i++) {
            outputArr[i]=L[i]*R[i];
        }


        return outputArr;
    }
}
