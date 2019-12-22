package Leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC1_TwoSum {
    public static void main(String[] args) {
        LC1_TwoSum lc1 = new LC1_TwoSum();
        System.out.println(Arrays.toString(lc1.twoSum(new int[]{2,7,11,15}, 9)));
    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsKey(target-nums[i])){
                map.put(nums[i], i);
            }
            else{
                return new int[]{map.get(target-nums[i]),i};
            }


        }
        return new int[]{};

    }
}
