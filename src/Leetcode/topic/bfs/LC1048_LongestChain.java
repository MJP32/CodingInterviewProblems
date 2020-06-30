package Leetcode.topic.bfs;

import java.util.HashMap;
import java.util.Map;

public class LC1048_LongestChain {
    public static void main(String[] args) {
        System.out.println(new LC1048_LongestChain().longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
    }
    public int longestStrChain(String[] words) {
        Map<String,Integer> chainMap = new HashMap<>();
        for (String word : words) {
            chainMap.put(word, 1);
        }
        //Arrays.sort(words, Comparator.comparingInt(String::length));
        int maxLength =0;

        return maxLength;
    }
}
