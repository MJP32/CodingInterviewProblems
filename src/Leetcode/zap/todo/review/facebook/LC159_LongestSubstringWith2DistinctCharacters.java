package Leetcode.zap.todo.review.facebook;

import java.util.HashMap;
import java.util.Map;

public class LC159_LongestSubstringWith2DistinctCharacters {
    public static void main(String[] args) {
        System.out.println(new LC159_LongestSubstringWith2DistinctCharacters().lengthOfLongestSubstringTwoDistinct("eceba"));
    }
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int maxLength = 0;
        int windowStart = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int windowEnd =0;windowEnd < s.length();windowEnd++){
            char rightChar = s.charAt(windowEnd);
            map.put(rightChar, map.getOrDefault(rightChar, 0) +1 );

            while(map.size() > 2){
                char leftChar = s.charAt(windowStart);
                map.put(leftChar, map.get(leftChar) -1);
                if(map.get(leftChar) ==0){
                    map.remove(leftChar);
                }

                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd-windowStart+1);
        }


        return maxLength;
    }
}
