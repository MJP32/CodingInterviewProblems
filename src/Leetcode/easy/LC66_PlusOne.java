package Leetcode.easy;

import java.util.Arrays;

public class LC66_PlusOne {
    public static void main(String[] args) {
        LC66_PlusOne lc66 = new LC66_PlusOne();
        System.out.println(Arrays.toString(lc66.plusOne(new int[]{1,2,3})));
        System.out.println(Arrays.toString(lc66.plusOne(new int[]{9,9})));
    }

    public int[] plusOne(int[] digits) {

        for (int i = digits.length -1; i >=0 ; i--) {

            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            else{
                digits[i] =0;
            }


        }
        int[] result = new int[digits.length+1];
        result[0] =1;
        return result;
    }
}