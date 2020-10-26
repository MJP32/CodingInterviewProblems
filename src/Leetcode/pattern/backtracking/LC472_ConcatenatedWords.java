package Leetcode.pattern.backtracking;


import java.util.*;

public class LC472_ConcatenatedWords {
    public static void main(String[] args) {
        String[] words = new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat",
                "ratcatdogcat"};
        new LC472_ConcatenatedWords().findAllConcatenatedWordsInADict(words).forEach(k -> System.out.println(k));
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>(Arrays.asList(words));

        for (String word : words) {
            if (canForm(word, set)) {
                result.add(word);
            }
        }


        return result;
    }

    private boolean canForm(String word, Set<String> set) {


        for (int i = 1; i < word.length(); i++) {
            String left = word.substring(0, i);
            String right = word.substring(i);
            if (set.contains(left)) {
                if (set.contains(right) || (canForm(right, set))) {
                    return true;
                }
            }
        }

        return false;
    }
}

