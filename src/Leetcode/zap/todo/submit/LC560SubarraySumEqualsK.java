package Leetcode.zap.todo.submit;

import java.util.HashMap;

public class LC560SubarraySumEqualsK {
    public static void main(String[] args) {
        LC560SubarraySumEqualsK lc560 = new LC560SubarraySumEqualsK();
        System.out.println(lc560.subArraySum(new int[]{1,1,1}, 2));

    }
    public int subArraySum(int[] nums, int k ){

        HashMap<Integer,Integer> arrSums = new HashMap<>();
        arrSums.put(0,1);
        int sum =0;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if(arrSums.containsKey(sum -k)){
                result += arrSums.get(sum -k);
            }
            arrSums.put(sum, arrSums.getOrDefault(sum, 0)+1);
        }
        return result;
    }
}
