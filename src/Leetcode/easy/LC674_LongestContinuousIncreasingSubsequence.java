package Leetcode.easy;

public class LC674_LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {

        System.out.println(new LC674_LongestContinuousIncreasingSubsequence().findLengthOfLCIS(new int[]{1,3,5,4,7}));

    }
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length ==1){
            return 0;
        }

        int max=1;
        int curr =1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]){
                curr++;
            }
            else{
                curr=1;
            }
            max = Math.max(max, curr);
        }

        return max;
    }
}
