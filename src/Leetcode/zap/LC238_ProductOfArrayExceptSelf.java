package Leetcode.zap;

public class LC238_ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        LC238_ProductOfArrayExceptSelf lc238 = new LC238_ProductOfArrayExceptSelf();


    }

    public int[] productExceptSelf(int[] nums) {
        int results = 0;

        int N = nums.length;

        int[] outputArr = new int[N];

        outputArr[0] =1;
        for (int i = 0; i < nums.length; i++) {
            outputArr[i] = nums[i-1] * outputArr[i-1];
        }


        return nums;
    }
}
