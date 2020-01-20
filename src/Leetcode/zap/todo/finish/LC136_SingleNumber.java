package Leetcode.zap.todo.finish;

import java.util.HashMap;
import java.util.Map;

public class LC136_SingleNumber {
    public static void main(String[] args) {

        System.out.println(new LC136_SingleNumber().singleNumber(new int[]{2,2, 1}));
    }
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map =new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

/*
        for (Map.Entry entry :map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }*/


        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }

        return 0;
    }
}
