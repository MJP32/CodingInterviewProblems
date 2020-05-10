package Leetcode.zap.todo.review.facebook;

import Leetcode.zap.todo.submit.LC560SubarraySumEqualsK;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC560_SubarraySumEqualsK {
    public static void main(String[] args) {
        //System.out.println(lc560.subArraySum(new int[]{1,1,1}, 2));
        System.out.println(new LC560_SubarraySumEqualsK().subArraySum(new int[]{3,4,7,2, -3,1, 4,2}, 7));
        System.out.println(new LC560_SubarraySumEqualsK().subArraySumSet(new int[]{3,4,7,2, -3,1, 4,2}, 7));

    }




    public int subArraySumSet(int[] nums, int k ){
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int subarrayCount = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(set.contains(sum -k)){
                subarrayCount++;
            }

            set.add(nums[i]);
        }

        return subarrayCount;
    }
    public int subArraySum(int[] nums, int k ){

        HashMap<Integer,Integer> arrSums = new HashMap<>();
        arrSums.put(0,1);
        int sum =0;
        int subarrayCount = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if(arrSums.containsKey(sum -k)){
               subarrayCount += arrSums.get(sum -k);
               // subarrayCount++;
            }
            arrSums.put(sum, arrSums.getOrDefault(sum, 0)+1);
        }

//        for (Map.Entry<Integer,Integer> entry : arrSums.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
        return subarrayCount;
    }
}
