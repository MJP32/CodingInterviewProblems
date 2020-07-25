package KeepOnCoding;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubstringOfAllChracters {
    public static void main(String[] args) {

        System.out.println(getShprtestUniqueSubstring(new char[]{'x', 'z', 'y'}, "xyyzyzyx"));
    }

    static String getShprtestUniqueSubstring(char[] chars, String str) {

        String result = "";
        int minLen = Integer.MAX_VALUE;


        int start = 0;
        int end = 0;

        Map<Character, Integer> characterFrequencyMap = new HashMap<>();

        for (Character c : chars) {
            characterFrequencyMap.put(c, characterFrequencyMap.getOrDefault(c, 0) + 1);
        }

        int matched = 0;

        for (int i = 0; i < str.length(); i++) {
            char rightChar = str.charAt(i);

            if (characterFrequencyMap.containsKey(rightChar)) {
                characterFrequencyMap.put(rightChar, characterFrequencyMap.get(rightChar) - 1);

                if (characterFrequencyMap.get(rightChar) >= 0) {
                    matched++;
                }
            }

            while (matched == chars.length) {

                int currMin = i - start + 1;

                if (currMin < minLen) {
                    minLen = currMin;
                    result = str.substring(start, i + 1);
                }


                char leftChar = str.charAt(start);
                if (characterFrequencyMap.containsKey(leftChar)) {
                    if (characterFrequencyMap.get(leftChar) == 0) {
                        matched--;
                    }
                    characterFrequencyMap.put(leftChar, characterFrequencyMap.get(leftChar) + 1);
                }
                start++;

            }

        }
        return result;

    }
}