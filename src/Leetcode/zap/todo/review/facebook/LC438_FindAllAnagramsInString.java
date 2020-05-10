package Leetcode.zap.todo.review.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC438_FindAllAnagramsInString {
    public static void main(String[] args) {
        //new LC438_FindAllAnagramsInString().findAnagrams("cbaebabacd","abc").forEach(k-> System.out.print(k));
//        new LC438_FindAllAnagramsInString().findAnagrams("abab","ab").forEach(k-> System.out.print(k));
        //new LC438_FindAllAnagramsInString().findAnagrams("baa","aa").forEach(k-> System.out.print(k));
        new LC438_FindAllAnagramsInString().findAnagrams("cbaebabacd","abc").forEach(k-> System.out.print(k));
    }
    public List<Integer> findAnagrams(String s, String p) {

        int[] charMap = new int[26];
        for(char c : p.toCharArray()){
            charMap[c- 'a']++;
        }
        System.out.println(Arrays.toString(charMap));



        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length()-p.length()+1 ; i++) {
            int start = i;
            int end = i+p.length();
            int[] copyArray = charMap.clone();
           // System.arraycopy(charMap,0,copyArray,0,25);

            if(isValid(s.substring(start, end), p, copyArray)){
                result.add(start);
                //i =i+2;
            }

        }
        return result;

    }

    private boolean isValid(String s, String p, int[] charMap) {

        int left =0;
        int right =0;
        int count = p.length();

        while (right < s.length()) {
            if (charMap[s.charAt(right++) -'a']-- >= 1) {
                count--;
            }
            if(count ==0)
                return true;
//            if(right - left == p.length() && charMap[s.charAt(left++) -'a']++ >= 0 ){
//                count++;
//            }

        }
        return false;

    }
}
