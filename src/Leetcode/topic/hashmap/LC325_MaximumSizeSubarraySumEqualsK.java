package Leetcode.topic.hashmap;

import java.util.HashMap;

public class LC325_MaximumSizeSubarraySumEqualsK {
    public static void main(String[] args) {
//        Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
//
//        Note:
//        The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
//
//                Example 1:
//
//        Input: nums = [1, -1, 5, -2, 3], k = 3
//        Output: 4
//        Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
//
//        Example 2:
//
//        Input: nums = [-2, -1, 2, 1], k = 1
//        Output: 2
//        Explanation: The subarray [-1, 2] sums to 1 and is the longest.
//
//        Follow Up:
//        Can you do it in O(n) time?



                System.out.println(new LC325_MaximumSizeSubarraySumEqualsK().maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3));
                System.out.println(new LC325_MaximumSizeSubarraySumEqualsK().maxSubArrayLen(new int[]{-2, -1, 2, 1},1));
//        1 -> 0
//        0 -> 1
//        5 -> 2
//        6 -> 4
//        3 -> 3

//            -2 -> 0
//            -3 -> 1
//            -1 -> 2
//            -2 -> 3

/*
    1. add first element to sum
    2. does sum equal k? if yes store index of element in result +1 as length
    3. Is sum- k in the map? if yes
 */


    }
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int result=0;
        for (int i = 0; i < nums.length; i++) {
            sum +=nums[i];
            if (sum == k) {
                result = i +1;
            }
            else if(map.containsKey(sum-k)){
                result = Math.max(result, i -map.get(sum-k));
            }

            if (!map.containsKey(sum)) {
                map.put(sum,i);
            }
        }
        return result;
    }
}
