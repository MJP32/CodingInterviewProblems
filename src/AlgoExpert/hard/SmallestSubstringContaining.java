package AlgoExpert.hard;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubstringContaining {
    public static void main(String[] args) {
        System.out.println(smallestSubstringContaining("abcd$ef$axb$c$", "$$abf"));
        //f$axb$
    }


    public static String smallestSubstringContaining(String bigString, String smallString) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> mapOrig = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        String smallestString = "";
        int windowStart = 0;
        int match = 0;
        for (Character c : smallString.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int windowEnd = 0; windowEnd < bigString.length(); windowEnd++) {
            char rightChar = bigString.charAt(windowEnd);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) >= 0) {
                    match++;
                }
            }
            while (match == smallString.length()) {
                int length = windowEnd - windowStart + 1;
                if (length < minLength) {
                    minLength = windowEnd - windowStart + 1;
                    smallestString = bigString.substring(windowStart, windowEnd + 1);
                }
                char leftChar = bigString.charAt(windowStart++);
                if (map.containsKey(leftChar)) {
                    // note that we could have redundant matching characters, therefore we'll decrement the
                    // matched count only when a useful occurrence of a matched character is going out of the window
                    if (map.get(leftChar) == 0)
                        match--;
                    map.put(leftChar, map.get(leftChar) + 1);
                }
            }
        }
        return smallestString;
    }
}

