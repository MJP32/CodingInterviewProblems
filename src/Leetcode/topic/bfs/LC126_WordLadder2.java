package Leetcode.topic.bfs;

import java.util.*;

public class LC126_WordLadder2 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        //list.add("cog");
       new LC126_WordLadder2().findLadders("hit","cog" ,list).forEach(k-> System.out.println(k));
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> results = new ArrayList<>();
        //results.add(beginWord);
        Set<String> set = new HashSet<String>(wordList);

        int count = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String currWord = queue.poll();
                // found the endWord, return!
                if(currWord.equals(endWord))
                    return results;

                for(int j = 0; j < currWord.length(); j++) {
                    for(char next = 'a'; next <= 'z'; next++) {
                        if(currWord.charAt(j) == next)
                            continue;
                        StringBuilder sb = new StringBuilder(currWord);
                        sb.setCharAt(j, next);
                        if(set.contains(sb.toString())) {
                            set.remove(sb.toString());
                            queue.add(sb.toString());

                        }
                    }
                }
            }
            //results.
            //count++;
        }
        return results;

    }
}
