package Leetcode.topic.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC76_MinimumWindowSubstring {
    public static void main(String[] args) {
        //System.out.println(new LC76_MinimumWindowSubstring().minWindow("ADOBECODEBAKNCWW", "ABC"));
       //System.out.println(new LC76_MinimumWindowSubstring().minWindow("aa", "aa"));
        System.out.println(new LC76_MinimumWindowSubstring().minWindow("bbaa", "aba"));


    }

    public String minWindow(String s, String t) {


        Map<Character, Integer> charMap = new HashMap<>();
        int windowStart =0;
        int minLength=Integer.MAX_VALUE;
        int match =0;

        for(Character c: t.toCharArray()){
            charMap.put(c, charMap.getOrDefault(c,0) +1);
        }


        String result ="";

        int[] ans = new int[2];
        for(int windowEnd =0; windowEnd < s.length();windowEnd++) {

            char rightChar = s.charAt(windowEnd);

            if (charMap.containsKey(rightChar)) {
                charMap.put(rightChar, charMap.get(rightChar) - 1);

                if (charMap.get(rightChar) >= 0) {
                    match++;
                }
            }


            while (match == t.length()) {
                //minLength = Math.min(minLength, windowEnd - windowStart + 1);

                if((windowEnd - windowStart + 1)<minLength){
                    minLength = windowEnd - windowStart + 1;
                    ans[0] = windowStart;
                    ans[1] = windowEnd+1;

                }


                char leftChar = s.charAt(windowStart);
                if (charMap.containsKey(leftChar)) {
                    if (charMap.get(leftChar) == 0) {
                        match--;

                    }
                    charMap.put(leftChar, charMap.get(leftChar) + 1);


                }
                windowStart++;


            }

        }
            result = s.substring(ans[0], ans[1]);


        return result;
    }
}
