package Leetcode.topic.twopointers;

public class LC713_SubarrayProductLessThanK {
    public static void main(String[] args) {
        /*
        Your are given an array of positive integers nums.

        0
        */
        System.out.println(new LC713_SubarrayProductLessThanK().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6},
                100));
        System.out.println(new LC713_SubarrayProductLessThanK().numSubarrayProductLessThanK(new int[]{1,1,1},
                1));
    }



    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <=1 || nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int right = 0;
        int left = 0;
        int total =1;
        while (right < nums.length) {
            total *= nums[right];

            while(total >=k){
                total  /=nums[left];
                left++;
            }
            count += right-left+1;
            right++;

        }
        return count;
    }
}
