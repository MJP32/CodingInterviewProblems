package Leetcode.topic.twopointers;

public class LC209_MInimumSizeSubarraySum {
    public static void main(String[] args) {
        /*

        Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

        Example:

        Input: s = 7, nums = [2,3,1,2,4,3]
        Output: 2
        Explanation: the subarray [4,3] has the minimal length under the problem constraint.
         */
        System.out.println(new LC209_MInimumSizeSubarraySum().minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
    public int minSubArrayLen(int s, int[] nums) {

        int result = Integer.MAX_VALUE;
        //int result = 0;
        int left = 0;
        int sum =0;

        for (int i = 0; i < nums.length; i++) {
            sum +=nums[i];

            while (sum >=s) {
                result = Math.min(result,i+1-left);
                sum -=nums[left];
                left++;
            }
        }

        return result !=Integer.MAX_VALUE ?result:0;



    }
}
