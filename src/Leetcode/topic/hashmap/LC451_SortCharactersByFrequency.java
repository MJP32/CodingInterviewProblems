package Leetcode.topic.hashmap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LC451_SortCharactersByFrequency {
    public static void main(String[] args) {
        System.out.println(new LC451_SortCharactersByFrequency().frequencySort("trree"));
        System.out.println(new LC451_SortCharactersByFrequency().frequencySort("cccaaa"));
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(Character c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        LinkedHashMap<Character, Integer> reverseSortedMap = new LinkedHashMap<>();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
                //.forEach(System.out::println);


        StringBuilder result = new StringBuilder();

        for (Map.Entry<Character,Integer> entry : reverseSortedMap.entrySet()){
                int count = entry.getValue();
                while(count > 0){
                    result.append(entry.getKey());
                    count--;
                }

        }
//            System.out.println("Key = " + entry.getKey() +
//                    ", Value = " + entry.getValue());

        return result.toString();

    }
}
