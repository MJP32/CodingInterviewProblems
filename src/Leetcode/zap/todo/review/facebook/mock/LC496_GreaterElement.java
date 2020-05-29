package Leetcode.zap.todo.review.facebook.mock;

import java.util.Arrays;

public class LC496_GreaterElement {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LC496_GreaterElement().nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2})));
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int j;
        for (int i = 0; i < nums1.length; i++) {
            boolean found = false;
            for (j = 0; j < nums2.length; j++) {
                if (found && nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                }
                if (nums2[j] == nums1[i]) {
                    found = true;
                }
            }
            if (j == nums2.length) {
                res[i] = -1;
            }
        }
        return res;
    }
}
