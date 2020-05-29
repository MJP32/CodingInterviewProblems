package AlgoExpert.hard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutDuplication {
    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutDuplication("clementisacap"));
//        System.out.println(longestSubstringWithoutDuplication("abcdeabcdefc"));
        System.out.println(longestSubstringWithoutDuplication("abacacacaaabacaaaeaaafa"));
    }
    public static String longestSubstringWithoutDuplication(String str) {
        int windowStart =0;
        int maxLength = 0;
        String result="";
        Map<Character, Integer> map = new HashMap<>();

        for(int windowEnd =0;windowEnd < str.length();windowEnd++){
            char rightChar = str.charAt(windowEnd);
            map.put(rightChar, map.getOrDefault(rightChar, 0) +1);
            while(map.get(rightChar)> 1){
                char leftChar = str.charAt(windowStart);
                map.put(leftChar, map.get(leftChar) -1);
                if(map.get(leftChar) ==0){
                    map.remove(leftChar);
                }
                windowStart++;
            }
            if(maxLength < (windowEnd- windowStart+1) ){
                result = str.substring(windowStart, windowEnd+1);
                maxLength = windowEnd- windowStart+1;
            }

        }

        return result;
    }

}
