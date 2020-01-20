package Leetcode.easy;

import java.util.Arrays;

public class LC27_RemoveElement {
    public static void main(String[] args) {
     LC27_RemoveElement lc27 = new LC27_RemoveElement();
        System.out.println(lc27.removeElement(new int[]{3,2,2,3}, 3));


    }
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;

        while(i < n){
            if(nums[i]== val){
                nums[i] =nums[n-1];
                n--;
            }
            else
                i++;
        }


        System.out.println(Arrays.toString(nums));

        return n;
    }
}
