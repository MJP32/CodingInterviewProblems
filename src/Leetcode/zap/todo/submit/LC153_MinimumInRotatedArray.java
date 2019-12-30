package Leetcode.zap.todo.submit;

import java.util.Arrays;

public class LC153_MinimumInRotatedArray {
    public static void main(String[] args) {
        LC153_MinimumInRotatedArray lc153 = new LC153_MinimumInRotatedArray();
        //System.out.println(lc153.findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(lc153.findMin(new int[]{2,3,4,5,1}));
    }
    public int findMin(int[] nums) {
        if(nums == null || nums.length ==0){
            return -1;
        }

        if(nums.length ==1){
            return nums[0];
        }

        int left =0;
        int right = nums.length -1;
        while(left< right){
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[right] ){
                left = mid+1;
            }
            else{
                right =mid;
            }
        }

        return nums[left];
    }
}
