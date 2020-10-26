package Leetcode.topic.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC472_ConcatenatedWords {
    public static void main(String[] args) {


    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();

        Set<String> wordSet = new HashSet<>();
        for(String word: words){
            wordSet.add(word);
        }

        for (String word : words) {

        }


        return result;
    }
}
