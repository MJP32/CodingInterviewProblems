package AlgoExpert.dp;

import java.util.*;

public class LongestStringChainRecursive {
    /*
                        abcdef
                          |
                        abcde
                       /
                   abde
                 /    \
              abd      ade
                       \
                        ae
        */
    List<String> res = new ArrayList<>();


    public static void main(String[] args) {

        String[] arr = {"z","zz","zzz","abde", "abc", "abd","zzzz", "abcde", "ade", "ae", "labde","abcdef","e",
                "zzzzzzzzzzzzzzzzz"};
        Set<String> set = new HashSet<>();
        for (String a : arr) {
            set.add(a);
        }
        System.out.println(new LongestStringChainRecursive().longestLinks(set));
    }
    void buildChildren(String str, Set<String> set, Map<String, List<String>> graph) {

        graph.putIfAbsent(str, new ArrayList<>());
        for (int i = 0; i < str.length(); i++) {
            String newStr = str.substring(0,i) + str.substring(i+1);
            if (set.contains(newStr)) {
                graph.get(str).add(newStr);
            }
        }
    }

    List<String> longestLinks(Set<String> set) {
        Map<String, List<String>> graph = new HashMap<>();

        for (String str : set) {
            buildChildren(str, set, graph);
        }
        for(String str: set){
            Set<String> visited = new HashSet<>();
            backtrack(str, new ArrayList<>(), graph, visited);
        }
        return res;
    }

    boolean backtrack(String node, List<String> list, Map<String, List<String>> graph, Set<String> visited) {
        if (visited.contains(node)) return false;
        visited.add(node);
        list.add(node);
        if (res.size() < list.size()) {
            res = new ArrayList<>(list);
        }
        for (String child : graph.get(node)) {
            if (backtrack(child, list, graph, visited)) {
                list.remove(list.size() - 1);
            }
        }
        return true;
    }


}
