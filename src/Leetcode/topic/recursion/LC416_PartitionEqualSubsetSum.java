package Leetcode.topic.recursion;

import java.util.HashMap;
import java.util.Map;

public class LC416_PartitionEqualSubsetSum {
    public static void main(String[] args) {
        System.out.println(new LC416_PartitionEqualSubsetSum().canPartition(new int[]{1,5,11,5}));
    }

    public boolean canPartition(int[] nums){
        int total = 0;

        for(int i : nums){
            total +=i;
        }

        if (total%2 !=0) {
            return false;
        }

        return canPartition(nums, 0, 0, total, new HashMap<String,Boolean>());
    }
    public boolean canPartition(int[] nums, int index, int sum, int total, Map<String, Boolean> state){
        String current = index +""+sum;
        if(state.containsKey(current)){
            return state.get(current);
        }
        if(sum *2==total){
            return true;
        }

        if(sum *2 > total || index >= nums.length){
            return false;
        }

        boolean foundPartition = canPartition(nums, index+1, sum, total, state ) || canPartition(nums, index+1, sum + nums[index],
                total, state) ;

        state.put(current, foundPartition);
        return foundPartition;

    }




}
