package Leetcode;

import java.util.HashMap;


public class LC217_ContainsDuplicate {

    public static void main(String[] args) {
        LC217_ContainsDuplicate lc217= new LC217_ContainsDuplicate();
        System.out.println(lc217.containsDuplicate(new int[]{1,2,3,1}));
    }
    public boolean containsDuplicate(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0;i< nums.length;i++){

            if(map.containsKey(nums[i])){
                return true;
            }
            else{
                map.put(nums[i],1);
            }


        }
        return false;

    }
}
