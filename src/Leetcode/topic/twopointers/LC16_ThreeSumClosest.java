package Leetcode.topic.twopointers;

import java.util.Arrays;

public class LC16_ThreeSumClosest {
    public static void main(String[] args) {
        LC16_ThreeSumClosest lc15 = new LC16_ThreeSumClosest();
        System.out.println(lc15.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        //-4, -1, 1, 2
    }


    public int threeSumClosest(int[] nums, int target) {

        if (nums == null || nums.length < 2) {
            return 0;
        }
        int result = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int currSum = nums[i] + nums[start] + nums[end];
                if (currSum > target) {
                    end--;
                } else {
                    start++;
                }
                if(Math.abs(currSum - target)< Math.abs(result - target)){
                    result = currSum;
                }
            }
        }
        return result;
    }
}
