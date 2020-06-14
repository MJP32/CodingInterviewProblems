package Leetcode.topic.sort;

import java.util.Arrays;

public class LC280_WiggleSort {
    public static void main(String[] args) {
        new LC280_WiggleSort().wiggleSort(new int[]{8,5,6,7,9,1,2});

    }
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i % 2 == 0) == (nums[i] > nums[i + 1])) {
                swap(nums, i, i + 1);
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
