package Leetcode.pattern.topologicalsort;

import java.util.*;

public class LC269_AlienDictionary {
    public static void main(String[] args) {
        String[] words = {"za", "zb", "ca", "cb"};
//        String[] words = {"abc", "ab"};
        System.out.println(new LC269_AlienDictionary().alienOrder(words));
    }

    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        String ans = "";
        HashMap<Character, Integer> depCount = new HashMap<>();
        HashMap<Character, List<Character>> dependencies = new HashMap<>();

        for (String word : words) {
            for (char letter : word.toCharArray()) {
                depCount.put(letter, 0);
                dependencies.put(letter, new ArrayList<>());
            }

        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            // Check that word2 is not a prefix of word1.
            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }
            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char parent = w1.charAt(j);
                char child = w2.charAt(j);
                if (parent != child) {
                    dependencies.get(parent).add(child);
                    depCount.put(child, depCount.get(child) + 1);
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : depCount.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        while (!queue.isEmpty()) {
            Character c = queue.poll();
            ans += c;
            List<Character> children = dependencies.get(c);
            for (Character child : children) {
                depCount.put(child, depCount.get(child) - 1);
                if (depCount.get(child) == 0) {
                    queue.add(child);
                }
            }
        }

        if (ans.length() != depCount.size())
            return "";

        return ans;
    }

}
