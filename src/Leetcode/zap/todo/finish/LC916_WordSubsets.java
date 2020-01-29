package Leetcode.zap.todo.finish;

import java.util.ArrayList;
import java.util.List;

public class LC916_WordSubsets {
    public static void main(String[] args) {
new LC916_WordSubsets().wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"},new String[]{"e","o"}).forEach(k -> System.out.println(k));
    }
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> result  = new ArrayList<>();
        int[] maxBFrequencies = new int[26];

        for (int i = 0; i < B.length; i++) {
            String currWord = B[i];
            int[] charFrequencies = getCharFrequency(currWord);

            for (int j = 0; j < 26; j++) {
                maxBFrequencies[j]=Math.max(maxBFrequencies[j], charFrequencies[j]);
            }
        }

        for (int i = 0; i < A.length; i++) {
            String currWord = A[i];
            int[] charCounts = getCharFrequency(currWord);
            boolean valid = true;

            for (int j = 0; j < 26; j++) {
                if (maxBFrequencies[j] >charCounts[j]) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                result.add(currWord);
            }
        }
        return result;
    }

    public int[] getCharFrequency(String S){
        int[] result = new int[26];
        for (char c: S.toCharArray()){
            result[c-'a']++;
        }
        return result;

    }
}
