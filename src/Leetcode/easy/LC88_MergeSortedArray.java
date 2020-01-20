package Leetcode.easy;

import java.util.Arrays;

public class LC88_MergeSortedArray {
    public static void main(String[] args) {
        LC88_MergeSortedArray lc88 = new LC88_MergeSortedArray();

        int [] nums1 = new int[]{1,2,3,0,0,0};
                int m = 3;
        int[] nums2 = new int[]{2,5,6};
        int n = 3;

        //lc88.merge(nums1, m, nums2, n);

        lc88.merge(new int[]{0}, 0, new int[]{1}, 1);



    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;

        int index = nums1.length-1;

        while (index >= 0){
            if(m<0){
                nums1[index]= nums2[n--];
            }
            else if(n<0){
                nums1[index]=nums1[m--];
            }
            else{
                if (nums1[m] > nums2[n]) {
                    nums1[index] = nums1[m--];
                } else {
                    nums1[index] = nums2[n--];
                }
            }
            index--;
        }



        System.out.println(Arrays.toString(nums1));
    }
}
