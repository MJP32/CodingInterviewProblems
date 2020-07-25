package Grokking.CH13_TopKElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeString {
    public static void main(String[] args) {
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
        System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
    }

    public static String rearrangeString(String str) {

        Map<Character, Integer> frequencyMap = new HashMap<>();
        PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((e1,e2) -> e2.getValue()
                -e1.getValue());
        for(char c : str.toCharArray()){
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) +1);
        }

        maxHeap.addAll(frequencyMap.entrySet());


        Map.Entry<Character,Integer> previouisEntry = null;

        StringBuilder result = new StringBuilder();
        while(!maxHeap.isEmpty()){
            Map.Entry<Character,Integer> currentEntry = maxHeap.poll();
            if (previouisEntry != null && previouisEntry.getValue()>0) {
                maxHeap.offer(previouisEntry);
            }
            result.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue()-1);
            previouisEntry = currentEntry;

        }


        return result.length()==str.length()?result.toString():"";
    }
}
