package Leetcode.topic.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC49_GroupedAnagrams {
    public static void main(String[] args) {
        /*
            Given an array of strings, group anagrams together.

            Input: "eat", "tea", "tan", "ate", "nat", "bat"

            Output: [act, tac, cat]
                    [flop, olfp]
                    [yo, oy]
         */

        /*
            1.  Loop through each word in list
            2.  Convert each word char array
            3.  Sort each word by character
            4.  Check to see if sorted word is in map
            5.  if not put as key
            6.  if exist put original (not sorted word) as value to that key
            7.  put values as answer in List<List<String>>
        */

        LC49_GroupedAnagrams lc43 = new LC49_GroupedAnagrams();
        lc43.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).forEach(k-> System.out.println(k));

    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for (String current : strs){
            char[] character = current.toCharArray();
            Arrays.sort(character);
            String sorted = new String(character);
            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(current);
        }
        results.addAll(map.values());
        return results;
    }
}
