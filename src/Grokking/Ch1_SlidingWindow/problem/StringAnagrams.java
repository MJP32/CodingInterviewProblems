package Grokking.Ch1_SlidingWindow.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagrams {

    public static void main(String[] args) {
        System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
        System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));
    }


    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();


        Map<Character,Integer> charFrequencyMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {

            char key = pattern.charAt(i);
            charFrequencyMap.put(key, charFrequencyMap.getOrDefault(key, 0)+1);
        }

        int matches =0;
        int windowstart =0;
        for (int windowEnd = 0; windowEnd <str.length(); windowEnd++) {

            char rightChar = str.charAt(windowEnd);
            if(charFrequencyMap.containsKey(rightChar)){

                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar)-1);

                if(charFrequencyMap.get(rightChar)==0){
                    matches++;
                }

                if(matches == pattern.length()){
                    resultIndices.add(windowstart);
                }

                if(windowEnd>=pattern.length()-1){
                    char leftChar = str.charAt(windowstart++);
                    if (charFrequencyMap.containsKey(leftChar)) {
                        if (charFrequencyMap.get(leftChar) ==0) {
                            matches --;
                        }
                    }
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar)+1);
                }

            }


        }


        return resultIndices;
    }
}
