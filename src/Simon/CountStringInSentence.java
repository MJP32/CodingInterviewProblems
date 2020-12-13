package Simon;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountStringInSentence {
    public static void main(String[] args) {
        String sentence = "I have a cat. My cat is black";
        countWords(sentence);
    }

    public static int countWords(String sentence){
        int count=0;
        String newsentence = sentence.replaceAll("."," ");
        String[] words= newsentence.split("\\s+");

        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : words){

            wordCounts.put(word, wordCounts.getOrDefault(word,0)+1);

       }

       wordCounts.forEach((k,v) -> System.out.println(k + " "+v));

        Set<String> keys = wordCounts.keySet();
        Integer[] values = wordCounts.values().toArray(new Integer[0]);


        return count;
    }
}
