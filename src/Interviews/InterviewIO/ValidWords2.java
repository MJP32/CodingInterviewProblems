package Interviews.InterviewIO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidWords2 {
    public static void main(String[] args) {
        /*
        There is a broken keyboard in which space gets typed when you type the letter 'e'. Given an input string which is the output from the keyboard. A dictionary of possible words is also provided as an input parameter of the method. Return a list of possible actual input typed by the user.

        Example Input: String: "can s r n " Dictionary: ["can", "canes", "serene", "rene", "sam"]
        Expected Output: ["can serene", "canes rene"]

        */
        System.out.println(new Leetcode.topic.trie.ValidWords().validateWords(new String[] {"can", "canes", "serene", "rene", "same"}, "can s r n  sam "));
    }

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
    public ValidWords2() {
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

}
