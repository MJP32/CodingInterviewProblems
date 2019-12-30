package Leetcode.zap.todo.finish;

import java.util.Arrays;

public class LC26_RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        LC26_RemoveDuplicatesFromSortedArray lc26 = new LC26_RemoveDuplicatesFromSortedArray();
        System.out.println(lc26.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
        System.out.println(lc26.removeDuplicates(new int[]{1,1,2}));
    }
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        System.out.println(Arrays.toString(nums));
        return i + 1;
    }
}
