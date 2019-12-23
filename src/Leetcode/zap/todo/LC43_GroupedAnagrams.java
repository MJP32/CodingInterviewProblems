package Leetcode.zap.todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC43_GroupedAnagrams {
    public static void main(String[] args) {
        LC43_GroupedAnagrams lc43 = new LC43_GroupedAnagrams();
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
