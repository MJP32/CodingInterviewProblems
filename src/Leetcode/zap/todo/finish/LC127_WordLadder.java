package Leetcode.zap.todo.finish;

import java.util.ArrayList;
import java.util.List;

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
return 1;
    }
}
