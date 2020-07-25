package Leetcode.zap.todo.finish;

import java.util.LinkedList;
import java.util.List;

public class LC647_PalindromicSubstring {
    public static void main(String[] args) {
        List<String> substr = substrings("abc");

        int count =0;

        for (String s : substr) {
            if(isPalindrome(s)){
                count++;
            }
        }
        System.out.println(count);

    }
    public static boolean isPalindrome(String s){
        if(s.length() <=1){
            return true;
        }

        return s.charAt(0) == s.charAt(s.length()-1) && isPalindrome(s.substring(1,s.length()-1));
    }

    public static List<String> substrings(String s){
        List<String> result = new LinkedList<>();
        iterateOverFirstCharacters(s,0,result);
        return result;
    }

    private static void iterateOverFirstCharacters(String s, int i, List<String> result) {
        if (i>=s.length()) {
            return;
        }
        iterateOverSecondCharacters(s, i, i+1, result);
        iterateOverFirstCharacters(s, i+1, result);
    }

    private static void iterateOverSecondCharacters(String s, int i, int j, List<String> result) {
        if(j >s.length()){
            return;
        }
        result.add(s.substring(i,j));
        iterateOverSecondCharacters(s,i,j+1, result);
    }

}
