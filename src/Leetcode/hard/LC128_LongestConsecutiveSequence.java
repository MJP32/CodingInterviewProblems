package Leetcode.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC128_LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(new LC128_LongestConsecutiveSequence().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int max =0;
        for(int i: nums){
            if(!set.contains(i)){
                continue;
            }

            int left =i -1;
            int right = i +1;
            int currLength =1;

            while(set.contains(left)){
                currLength++;
                left--;
            }

            while(set.contains(right)){
                currLength++;
                right++;
            }


            if(max < currLength){
                max = currLength;
            }


        }


        return max;

    }
}
