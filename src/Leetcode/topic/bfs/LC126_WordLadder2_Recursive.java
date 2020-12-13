package Leetcode.topic.bfs;

import java.util.*;

public class LC126_WordLadder2_Recursive {

    List<List<String>> res = new ArrayList<>();

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");

        list.add("hat");
        list.add("cat");
        list.add("cal");
        list.add("col");
        //list.add("cog");
        new LC126_WordLadder2_Recursive().findLadders("hit", "cog", list).forEach(k -> System.out.println(k));
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graph;
        graph = buildGraphBFS(beginWord, wordList);
        System.out.println(graph);
        backtrack(beginWord, endWord, new ArrayList<>(), graph);
        return res;
    }


    /*
               hit
              /  \
            hot   hat
            /\     \
          dot lot   cat
          /    \
        dog    log
        /        \
      cog        cog


               hit
              /  \
            hot   hat
            /\     \
          dot lot   cat
          /    \       \
        dog    log     cal
        /        \        \
      cog        cog      col
                            \
                             cog
     */
    private void backtrack(String beginWord, String endWord, List<String> path, Map<String,
            List<String>> graph) {

        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
        }
        if (path.size() == 0) {
            path.add(beginWord);
        }
        for (String child : graph.get(beginWord)) {
            path.add(child);
            backtrack(child, endWord, path, graph);
            path.remove(path.size() - 1);
        }
    }

    private Map<String, List<String>> buildGraphBFS(String beginWord, List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> level = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();

        queue.add(beginWord);
        visited.add(beginWord);
        level.put(beginWord, 0);

        while (!queue.isEmpty()) {
            String parent = queue.poll();
            graph.put(parent, new ArrayList<>());
            for (int i = 0; i < parent.length(); i++) {
                for (char next = 'a'; next <= 'z'; next++) {
                    StringBuilder child = new StringBuilder(parent);
                    child.setCharAt(i, next);
                    String childString = child.toString();
                    if (!wordList.contains(childString) || childString.equals(parent)) {
                        continue;
                    } else if (visited.contains(childString)) {
                        if (level.get(childString) <= level.get(parent)) {
                            continue;
                        } else
                            graph.get(parent).add(childString);
                    } else {
                        visited.add(childString);
                        graph.get(parent).add(childString);
                        queue.add(childString);
                        level.put(childString, level.getOrDefault(parent, 0) + 1);
                    }
                }
            }
        }
        return graph;
    }
}
