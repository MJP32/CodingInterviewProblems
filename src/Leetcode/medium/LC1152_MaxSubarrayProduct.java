package Leetcode.medium;

public class LC1152_MaxSubarrayProduct {
    public static void main(String[] args) {
        LC1152_MaxSubarrayProduct lc152 = new LC1152_MaxSubarrayProduct();
        System.out.println(lc152.maxProduct(new int[]{2,3,-2,4}));

    }

    private int maxProduct(int[] nums) {
        if(nums.length ==0) return 1;
        int max = nums[0];
        int min = nums[0];

        int finalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);

            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);



            if(max  > finalMax)
                finalMax = max;

        }



        return finalMax;
    }
}
