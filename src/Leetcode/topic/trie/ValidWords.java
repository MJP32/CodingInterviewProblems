package Leetcode.topic.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidWords {
    class Trie{
        Map<Character, Trie> map;
        char ch;
        boolean isEnd;
        public Trie(char c) {
            this.ch = c;
            map = new HashMap<>();
        }
    }

    public Trie root;
    public ValidWords() {
        this.root = new Trie('#');
    }

    public void buildTrie(String[] words) {
        Trie temp;
        for(String word : words) {
            temp = root;
            for(char ch : word.toCharArray()) {
                if(!temp.map.containsKey(ch)) {
                    temp.map.put(ch, new Trie(ch));
                }
                temp = temp.map.get(ch);
            }
            temp.isEnd=true;
        }
    }

    public List<String> validateWords(String[] dictionary, String input){
        buildTrie(dictionary);
        List<String> matchWords = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        performDFS(input, 0, root, sb, matchWords);
        return matchWords;
    }

    // Depth First Search
    private void performDFS(String input,int index,Trie temp, StringBuilder sb, List<String> matchWords) {
        char ch;
        // base condition
        if(index == input.length() - 1) {
            ch = input.charAt(index);
            if(ch == ' ')
                ch = 'e';
            if(temp.map.containsKey(ch) && temp.map.get(ch).isEnd) {
                matchWords.add(sb.toString() + ch);
            }
            return;
        }
        ch = input.charAt(index);
        if(ch == ' ') {
            // either a space or char e
            // 1) space
            if(temp.isEnd) {
                sb.append(' ');
                performDFS(input, index+1, root, sb, matchWords);
                sb.deleteCharAt(sb.length()-1);
            }
            // 2) char e
            ch = 'e';
            if(temp.map.containsKey(ch)) {
                sb.append(ch);
                performDFS(input, index+1, temp.map.get(ch), sb, matchWords);
                sb.deleteCharAt(sb.length()-1);
            }
        }else {
            // check and proceed
            if(temp.map.containsKey(ch)) {
                sb.append(ch);
                performDFS(input, index+1, temp.map.get(ch), sb, matchWords);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new ValidWords().validateWords(new String[] {"can", "canes", "serene", "rene", "same"}, "can s r n  sam "));
    }
}
