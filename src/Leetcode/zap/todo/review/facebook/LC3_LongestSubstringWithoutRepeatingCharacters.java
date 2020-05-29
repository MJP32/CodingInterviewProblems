package Leetcode.zap.todo.review.facebook;

import java.util.HashSet;
import java.util.Set;

public class LC3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(new LC3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
    }
    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int maxLength =0;
        while(i < s.length() && j < s.length()){
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxLength = Math.max(maxLength, j-i);
            }
            else{
                set.remove(s.charAt(i++));
            }
        }
        return maxLength;
    }
}
