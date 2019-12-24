package Leetcode.zap.todo;

import java.util.HashSet;

public class LC349_IntersectionArrays {
    public static void main(String[] args) {

    }
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> result= new HashSet<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i =0;i< nums1.length;i++){
            set.add(nums1[i]);
        }

        for(int i =0;i< nums2.length;i++){
            if(set.contains(nums2[i])){
                result.add(nums2[i]);
            }


        }

        int[] finalResult = new int[result.size()];

        int i=0;
        for(Integer res : result){
            finalResult[i] = res;
            i++;
        }

        return finalResult;

    }
}
