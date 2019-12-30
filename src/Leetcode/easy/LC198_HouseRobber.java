package Leetcode.easy;

public class LC198_HouseRobber {
    public static void main(String[] args) {
        LC198_HouseRobber lc198 = new LC198_HouseRobber();
        System.out.println(lc198.rob(new int[]{2,1,1,2}));
    }
    public int rob(int[] nums) {


        if(nums ==null||nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }


        int[] dp =new int[nums.length];
        dp[0] = nums[0];
        dp[1]= Math.max(dp[0], nums[1]);


        for(int i =2;i< nums.length;i++)
        {
            dp[i]= Math.max(nums[i]+dp[i-2],dp[i-1] );


        }
        return nums[nums.length-1];
    }
}
