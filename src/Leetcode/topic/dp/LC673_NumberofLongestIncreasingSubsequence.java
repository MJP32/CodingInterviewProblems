package Leetcode.topic.dp;

import java.util.Arrays;

public class LC673_NumberofLongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(new LC673_NumberofLongestIncreasingSubsequence().findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(new LC673_NumberofLongestIncreasingSubsequence().findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
    }


    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] lengths = new int[nums.length];
        int[] sequences = new int[nums.length];

        Arrays.fill(lengths, 1);
        Arrays.fill(sequences, 1);
        for (int i = 1; i < nums.length; i++) {
            int j = 0;
            while (j < i) {
                if (nums[i] > nums[j]) {
                    if (lengths[j] >= lengths[i]) {
                        lengths[i] = lengths[j] + 1;
                        sequences[i] = sequences[j];
                    } else if (lengths[j] + 1 == lengths[i]) {
                        sequences[i] += sequences[j];
                    }
                }
                j++;
            }
        }
        //System.out.println(Arrays.toString(lengths));
        //System.out.println(Arrays.toString(sequences));
        int longest = 0, ans = 0;
        for (int length: lengths) {
            longest = Math.max(longest, length);
        }
        for (int i = 0; i < nums.length; ++i) {
            if (lengths[i] == longest) {
                ans += sequences[i];
            }
        }
        return ans;
    }
}
