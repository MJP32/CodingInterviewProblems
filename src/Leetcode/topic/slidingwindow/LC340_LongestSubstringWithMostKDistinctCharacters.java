package Leetcode.topic.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LC340_LongestSubstringWithMostKDistinctCharacters {

    public static void main(String[] args) {
        System.out.println(new LC340_LongestSubstringWithMostKDistinctCharacters().lengthOfLongestSubstringKDistinct("eceba",2));
    }
    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        int windowStart =0;
        int maxLength =0;

        Map<Character,Integer> charMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char c = s.charAt(windowEnd);
            charMap.put(c, charMap.getOrDefault(c,0) +1);

            while(charMap.size() >k){

                //remove leftmost from sliding window
                char leftchar = s.charAt(windowStart);

                if(charMap.containsKey(leftchar)){
                    charMap.put(leftchar, charMap.get(leftchar)-1);
                }
                if(charMap.get(leftchar) == 0){
                    charMap.remove(leftchar);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd-windowStart+1);

        }

        return maxLength;
    }
}
