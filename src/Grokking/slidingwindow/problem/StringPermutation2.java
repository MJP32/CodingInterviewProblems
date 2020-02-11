package Grokking.slidingwindow.problem;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation2 {
    public static void main(String[] args) {
        //System.out.println("Permutation exist: " + StringPermutation2.findPermutation("oidbcaf", "abc"));
//        System.out.println("Permutation exist: " + StringPermutation2.findPermutation("odicf", "dc"));
        //System.out.println("Permutation exist: " + StringPermutation2.findPermutation("bcdxabcdy", "bcdyabcdx"));
        //System.out.println("Permutation exist: " + StringPermutation2.findPermutation("aaacb", "abc"));
        System.out.println("Permutation exist: " + StringPermutation2.findPermutation("abcdxabcde","abcdeabcdx"));
        System.out.println("Permutation exist: " + StringPermutation2.findPermutation("ab","eidbaooo"));
    }

    public static boolean findPermutation(String str, String pattern) {
        // TODO: Write your code here

        int windowStart =0, matched =0;
        Map<Character,Integer> charFrequencyMap =new HashMap<>();
        for (char chr :pattern.toCharArray()){
            charFrequencyMap.put(chr,charFrequencyMap.getOrDefault(chr,0) +1);
        }

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);

            if(charFrequencyMap.containsKey(rightChar)){
                charFrequencyMap.put(rightChar,charFrequencyMap.get(rightChar)-1);
                if (charFrequencyMap.get(rightChar) ==0) {
                    matched++;
                }
            }

            if(matched == charFrequencyMap.size())
                return true;


            if (windowEnd>=pattern.length()-1) {
                char leftChar = str.charAt(windowStart++);
                if (charFrequencyMap.containsKey(leftChar)) {
                    if (charFrequencyMap.get(leftChar) ==0) {
                        matched--;

                    }
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar)+1);
                }
            }

        }

        return false;
    }
}