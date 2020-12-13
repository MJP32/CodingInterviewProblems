package Leetcode.topic.bfs;

import java.util.*;

public class LC127_WordLadder {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(new LC127_WordLadder().ladderLength("hit","cog" ,list));
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
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
                    return count+1;

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
            count++;
        }
        return 0;

    }
}
