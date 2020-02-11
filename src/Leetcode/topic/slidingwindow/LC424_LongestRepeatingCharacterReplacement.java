package Leetcode.topic.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LC424_LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {

        System.out.println(new LC424_LongestRepeatingCharacterReplacement().characterReplacement("ABAB", 2));
    }
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        int maxLength =0;
        int windowStart =0;
        int maxRepeatLetter =0;
        for(int windowEnd = 0;windowEnd< s.length();windowEnd++){
            char rightChar = s.charAt(windowEnd);
            charFrequencyMap.put(rightChar,charFrequencyMap.getOrDefault(rightChar, 0) +1);

            maxRepeatLetter = Math.max(maxRepeatLetter, charFrequencyMap.get(rightChar));


            if(windowEnd-windowStart+1-maxRepeatLetter >k){
                char leftChar = s.charAt(windowStart);
                charFrequencyMap.put(leftChar,charFrequencyMap.get(leftChar)-1);
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd -windowStart +1);
        }

        return maxLength;
    }
}
