package Leetcode.zap.todo.sandbox;

import java.util.Map;

public class HashMap {
    public static void main(String[] args) {
        Map<Integer, Integer> map =new java.util.HashMap<>();

        int[] nums = new int[]{1,2,3,4};
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

/*
        for (Map.Entry entry :map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }*/

int val = 0 ;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                val =  entry.getKey();
            }
        }

        System.out.println(val);
    }
}
