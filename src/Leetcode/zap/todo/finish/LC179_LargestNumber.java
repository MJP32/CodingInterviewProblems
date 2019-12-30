package Leetcode.zap.todo.finish;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LC179_LargestNumber {
    public static void main(String[] args) {
        LC179_LargestNumber lc179 = new LC179_LargestNumber();
        System.out.println(lc179.largestNumber(new int[]{3,30,34,5,9}));
    }
    public String largestNumber(int[] nums) {

        PriorityQueue<String> queue = new PriorityQueue<>();


        for(Integer i : nums){
            queue.add(String.valueOf(i));
        }

        Arrays.sort(queue.toArray(), Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();


        for(String i: queue){
            sb.append(i);

        }

        return sb.toString();
    }
}
