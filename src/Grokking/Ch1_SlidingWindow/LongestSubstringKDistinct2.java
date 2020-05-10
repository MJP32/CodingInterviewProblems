package Grokking.Ch1_SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct2 {
    public static void main(String[] args) {
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct2.findLength("araaci", 2));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct2.findLength("araaci", 1));
        System.out.println("Length of the longest substring: " + LongestSubstringKDistinct2.findLength("cbbebi", 3));
    }
    public static int findLength(String str, int k) {



        int windowStart = 0;
        int maxLength =0;

        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {

            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) +1);

            while(charFrequencyMap.size() > k){

                char leftChar = str.charAt(windowStart);

                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar)-1);
                if(charFrequencyMap.get(leftChar) == 0){

                    charFrequencyMap.remove(leftChar);
                }


                windowStart++;


            }

            maxLength = Math.max(maxLength, windowEnd -windowStart + 1 );



        }



        return maxLength;
    }
}
