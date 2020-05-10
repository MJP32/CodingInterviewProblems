package Leetcode.zap.todo.review.facebook;

import java.util.HashMap;

public class LC523_ContinousSubarraySum {
    public static void main(String[] args) {
        System.out.println(new LC523_ContinousSubarraySum().checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
//        System.out.println(new LC523_ContinousSubarraySum().checkSubarraySum(new int[]{2, 5, 33, 6, 7, 25, 15}, 13));
//        System.out.println(new LC523_ContinousSubarraySum().checkSubarraySum(new int[]{2, 5, 3}, 13));
    }
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            System.out.println(sum);
            sum += nums[i];
            if(k != 0){
                sum = sum %k;
            }
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) {
                    return true;
                }
                else{
                    map.put(sum, i);
                }
            }
        }
        return false;
    }
}
