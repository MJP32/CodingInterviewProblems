package Leetcode.topic.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC127_WordLadder {
    public static void main(String[] args) {

    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>();
        for(String word: wordList){
            set.add(word);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level =1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0; i < size;i++){
                String currWord = queue.poll();

            }

            level++;
        }

        return 0;
    }
}
