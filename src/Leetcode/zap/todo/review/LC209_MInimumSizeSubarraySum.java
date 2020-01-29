package Leetcode.zap.todo.review;

public class LC209_MInimumSizeSubarraySum {
    public static void main(String[] args) {

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
