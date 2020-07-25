package Leetcode.topic.twopointers;

import java.util.Arrays;

public class LC259_ThreeSumSmaller {
    public static void main(String[] args) {
        System.out.println(new LC259_ThreeSumSmaller().threeSumSmaller(new int[]{-2, 0, 1, 3}, 2));
        System.out.println(new LC259_ThreeSumSmaller().threeSumSmaller(new int[]{-2, 0, 1, 3}, 4));
        //-2,0,1
        //-2,0,3
        //
    }


    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;

            int t = target - nums[i];
            while (start < end) {

                if (nums[start] + nums[end] >= t) {
                    end--;
                } else {
                    count += end - start;
                    start++;
                }
            }
        }
        return count;
    }

}
