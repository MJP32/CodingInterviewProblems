package AlgoExpert.string;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        groupAnagrams2(Arrays.asList(new String[]{"yo", "act","flop", "tac","cat", "oy", "olfp"})).forEach(k-> System.out.println(k));
    }
    public static List<List<String>> groupAnagrams2(List<String> words) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String word : words){
            char[] c = word.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }
            // always put in value (sorted or unsorted )
            map.get(sorted).add(word);
        }
        result.addAll(map.values());
        return result;
    }
    public static List<List<String>> groupAnagrams(List<String> words) {
       /*
            1.  Loop through each word in list
            2.  Convert each word char array
            3.  Sort each word by character
            4.  Check to see if word is in map
            5.  if not put as key
            6.  put original (not sorted word) as value to that key
            7.  put answer in List<List<String>>
        */

       List<List<String>> result = new ArrayList<>();
       Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {

            char[] c = word.toCharArray();
            Arrays.sort(c);

            String sorted = new String(c);

            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(word);


        }
        result.addAll(map.values());

        return result;
    }
}
