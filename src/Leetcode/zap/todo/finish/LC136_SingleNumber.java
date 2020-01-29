package Leetcode.zap.todo.finish;

import java.util.HashMap;
import java.util.Map;

public class LC136_SingleNumber {
    public static void main(String[] args) {

        System.out.println(new LC136_SingleNumber().singleNumber(new int[]{2,2, 1}));
    }
    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int num : nums) {
            xor ^= num;
        }

        return xor;
    }
}
