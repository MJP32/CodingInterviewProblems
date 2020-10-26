package Leetcode.pattern.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC784_LetterCasePermutation {
    public static void main(String[] args) {
        new LC784_LetterCasePermutation().letterCasePermutation("a1b2").forEach(k -> System.out.println(k));
    }
    public int count =0;
    public List<String> letterCasePermutation(String S) {

        List<String> res = new ArrayList<>();
        findAllPermutations(res, S, 0);
        return res;
    }

    private void findAllPermutations(List<String> res, String word, int index) {
        System.out.println("*");
        res.add(word);
        for (int i = index; i < word.length(); i++) {
            System.out.println(count++);
            char[] wordArray = word.toCharArray();

            char c = word.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    wordArray[i] = Character.toLowerCase(c);
                } else {
                    wordArray[i] = Character.toUpperCase(c);
                }
                findAllPermutations(res, String.valueOf(wordArray), i + 1);
            }
        }

    }
}
