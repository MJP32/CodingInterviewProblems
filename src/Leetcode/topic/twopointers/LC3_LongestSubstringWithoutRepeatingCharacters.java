package Leetcode.topic.twopointers;

import java.util.HashSet;

public class LC3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

        LC3_LongestSubstringWithoutRepeatingCharacters lc3 = new LC3_LongestSubstringWithoutRepeatingCharacters();

        System.out.println(lc3.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lc3.lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {

        int i =0;
        int j =0;
        int max =0;

        HashSet<Character> set = new HashSet<>();

        while(j< s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, set.size());
            }
            else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;

    }


}
