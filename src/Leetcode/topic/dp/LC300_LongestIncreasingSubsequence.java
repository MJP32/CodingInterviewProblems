package Leetcode.topic.dp;

import java.util.Arrays;

public class LC300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(new LC300_LongestIncreasingSubsequence().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18, 1}));
    }
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length ==0) {
            return 0;
        }
        int[] lengths = new int[nums.length];
        int[] sequences = new int[nums.length];
        Arrays.fill(lengths, 1);
        for(int i =1; i< nums.length;i++){
            int j =0;

            while(j< i){
                if(nums[i] > nums[j]){
                    lengths[i] = Math.max(lengths[i], 1+ lengths[j]);
                    sequences[i] =j;
                }
                j++;
            }


        }
        System.out.println(Arrays.toString(lengths));
        System.out.println(Arrays.toString(sequences));
        int max = 1;
        for(int i : lengths){
            max = Math.max(i, max);
        }
        return max;
    }
}
