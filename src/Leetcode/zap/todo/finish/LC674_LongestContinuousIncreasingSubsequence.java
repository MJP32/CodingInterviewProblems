package Leetcode.zap.todo.finish;

public class LC674_LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        LC674_LongestContinuousIncreasingSubsequence lc674 = new LC674_LongestContinuousIncreasingSubsequence();
        System.out.println(lc674.findLengthOfLCIS(new int[]{1,3,5,4,7}));
    }
    public int findLengthOfLCIS(int[] nums) {
        int result=0;
        int begin =0;

        if(nums == null){
            return 0;
        }
        if(nums.length ==1){
            return 1;
        }


        for (int i = 1; i < nums.length; i++) {


            if(nums[i-1] >= nums[i]){
                begin =i;

            }

            result = Math.max(result, i-begin+1);
        }



        return result;
    }

}
