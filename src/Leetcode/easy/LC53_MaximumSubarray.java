package Leetcode.easy;

public class LC53_MaximumSubarray {
    public static void main(String[] args) {
        LC53_MaximumSubarray  lc53 = new LC53_MaximumSubarray();
        System.out.println(lc53.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4} ));
    }

    public int maxSubArray(int[] nums) {

        int[] table = new int[nums.length];
        int max = nums[0];
        table[0]=nums[0];

        for (int i = 1; i < nums.length; i++) {
            table[i] = Math.max(nums[i],nums[i] + table[i-1]);
            max =Math.max(max,table[i]);
        }
        return max;
    }
}
