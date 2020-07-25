package Leetcode.topic.hashmap;

import java.util.HashMap;

public class LC525_ContigousArray {
    public static void main(String[] args) {
        /*
        Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

        Example 1:
        Input: [0,1]
        Output: 2
        Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
        Example 2:
        Input: [0,1,0]
        Output: 2
        Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

         */

        LC525_ContigousArray lc525 = new LC525_ContigousArray();
        //System.out.println(lc525.findMaxLength(new int[]{0,0,1,1,0,1,0,1}));
        System.out.println(lc525.findMaxLength(new int[]{0,1}));
    }
    public int findMaxLength(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        int max =0 ;
        int count = 0;

        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] ==0){
                count += -1;
            }
            else{
                count +=1;
            }
            if(map.containsKey(count)){
                max = Math.max(max, i-map.get(count));
            }
            else{
                map.put(count,i);
            }
        }
//        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
//
//            System.out.println(entry.getKey() + " :" + entry.getValue());
//        }

        return max;
    }
}
