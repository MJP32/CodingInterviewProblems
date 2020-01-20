package Leetcode.zap.todo.finish;

import java.util.ArrayList;
import java.util.List;

public class LC438_FindAllANagramsInString {
    public static void main(String[] args) {
        LC438_FindAllANagramsInString  lc438 = new LC438_FindAllANagramsInString();
        lc438.findAnagrams("cbaebabacd", "abc").forEach(k-> System.out.println(k));
    }
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> results = new ArrayList<>();



        if(s.length()==0 || s==null)
            return null;

        int[] charCount = new int[26];

        for(char c :p.toCharArray()){
            charCount[c-'a']++;
        }

        int left =0;
        int right = 0;
        int count = p.length();

        while(right < s.length()){
            if (charCount[s.charAt(right++)-'a']-- >=1) {
                count--;
            }
            if(count==0){
                results.add(left);
            }
            if (right -left ==p.length() && charCount[s.charAt(left++)-'a']++ >=0) {
                count++;
            }
        }


        
        return results;
    }



}
