package Leetcode.zap.todo.sandbox;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        merge(new int[]{1,2,3,0,0,0},3,  new int[]{2,5,6}, 3);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        int index = nums1.length -1;

        while(index >= 0){

            if(n<0){
                nums1[index] = nums1[m--];
            }
            else if(m< 0){
                nums1[index] = nums2[n--];
            }
            else{
                if(nums1[m] > nums2[n]){
                    nums1[index] = nums1[m--];
                }
                else{
                    nums1[index] = nums2[n--];
                }

            }

            index--;

        }


        System.out.println(Arrays.toString(nums1));



    }
}
