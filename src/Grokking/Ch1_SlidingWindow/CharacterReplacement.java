package Grokking.Ch1_SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {
    public static void main(String[] args) {
//        System.out.println(CharacterReplacement.findLength("aabccbb", 2));
//        System.out.println(CharacterReplacement.findLength("abbcb", 1));
//        System.out.println(CharacterReplacement.findLength("abccde", 1));
        System.out.println(CharacterReplacement.findLength("ABAB", 2));

    }

    public static int findLength(String str, int k) {
        // TODO: Write your code here

        int maxLength =0;
        int windowStart =0;
        int maxRepeatLetterCount=0;
        Map<Character, Integer> letterFrequencyMap  = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);

            letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar,0) +1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(rightChar));


            if (windowEnd - windowStart + 1 - maxRepeatLetterCount  > k){

                char leftChar = str.charAt(windowStart);
                letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) -1);
                windowStart++;

            }


            maxLength=Math.max(maxLength, windowEnd - windowStart + 1);

        }











        return maxLength;
    }
}
