package Leetcode.topic.bfs;

import java.util.*;

public class LC126_WordLadder2 {
    public static void main(String[] args) {

        List<String> list2 = new ArrayList<>();
        list2.add("hot");
        list2.add("hat");
        list2.add("dot");
        list2.add("dog");
        list2.add("lot");
        list2.add("log");
        list2.add("cog");
       new LC126_WordLadder2().findLadders("hit","cog" ,list2).forEach(k-> System.out.println(k));

       List<String> list = new ArrayList<>();
        list.add("but");
        list.add("put");
        list.add("big");
        list.add("pot");
        list.add("pog");
        list.add("dog");
        list.add("lot");
        list.add("lot");
        list.add("pig");
        new LC126_WordLadder2().findLadders("bit", "dog", list).forEach(k -> System.out.println(k));
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> results = new ArrayList<>();
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<String>(wordList);

        Queue<List<String>> queue = new LinkedList<>();
        list.add(beginWord);
        queue.offer(list);

        while (!queue.isEmpty()) {
            if (!results.isEmpty())
                return results;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<String> tmpList = queue.poll();
                String currWord = tmpList.get(tmpList.size() - 1);
                set.remove(currWord);
                // found the endWord, return!
                if (currWord.equals(endWord)) {
                    results.add(new ArrayList<>(tmpList));
                }

                for (int j = 0; j < currWord.length(); j++) {
                    for (char next = 'a'; next <= 'z'; next++) {
                        if (currWord.charAt(j) == next)
                            continue;
                        StringBuilder sb = new StringBuilder(currWord);
                        sb.setCharAt(j, next);
                        if (set.contains(sb.toString())) {
                            tmpList.add(sb.toString());
                            queue.add(new ArrayList<>(tmpList));
                            tmpList.remove(tmpList.size() - 1);
                        }
                    }
                }
            }
        }
        return results;
    }
}
