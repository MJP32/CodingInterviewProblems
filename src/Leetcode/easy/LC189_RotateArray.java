package Leetcode.easy;

import java.util.Arrays;

public class LC189_RotateArray {
    public static void main(String[] args) {

        LC189_RotateArray lc189 = new LC189_RotateArray();
        lc189.rotate(new int[]{1,2,3,4,5,6,7},3);
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;

        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);

        System.out.println(Arrays.toString(nums));
    }

    private void reverse(int[] nums, int start, int end ) {


        while(start< end){

            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}
