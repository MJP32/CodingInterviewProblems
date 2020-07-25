package Leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;

public class LC819_MostCommonWord {
    public static void main(String[] args) {
        System.out.println(new LC819_MostCommonWord().mostCommonWord("Bob hit a ball, the hit BALL flew far after it" +
                " was hit.", new String[]{"hit"}));
    }
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> banSet = new HashSet<>();

        for(String word: banned)
            banSet.add(word.toLowerCase());

        HashMap<String, Integer> map = new HashMap<>();
        String[] goodString = paragraph.toLowerCase().split("\\W+");

        for(String word: goodString){
            if(!banSet.contains(word))
                map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int maxCount = 0;
        String result = "";

        for(String key : map.keySet()){
            if(maxCount < map.get(key)){
                maxCount = map.get(key);
                result = key;
            }
        }

        return result;
    }
}
