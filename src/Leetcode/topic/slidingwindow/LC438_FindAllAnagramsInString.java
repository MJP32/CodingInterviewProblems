package Leetcode.topic.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class LC438_FindAllAnagramsInString {
    public static void main(String[] args) {
        LC438_FindAllAnagramsInString lc438 = new LC438_FindAllAnagramsInString();
        lc438.findAnagrams("cbaebabacd", "abc").forEach(k -> System.out.println(k));
    }

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> results = new ArrayList<>();

        int[] charCounts = new int[26];
        for (int i = 0; i < p.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
        }

        int start = 0;
        int end = 0;
        int count = p.length();

        while (end < s.length()) {

            if (charCounts[s.charAt(end++) - 'a']-- >= 1) {
                count--;
            }
            if (count == 0) {
                results.add(start);
            }
            if (end-start == p.length() && charCounts[s.charAt(start++) - 'a']++ >= 0) {
                count++;
            }

        }


        return results;
    }


}
