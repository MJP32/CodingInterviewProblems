package Leetcode.topic.stg.submit;

import java.util.ArrayList;
import java.util.List;

public class LC131_PaliddromeParitioning {
    public static void main(String[] args) {
        new LC131_PaliddromeParitioning().partition("aab").forEach(k-> System.out.println(k));
    }

    public List<List<String>> partition(String s ){
        List<List<String>> result = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void dfs(String s, int index, ArrayList<String> palindrome, List<List<String>> result) {
        if(index == s.length()){
            result.add(new ArrayList<>(palindrome));
            return;
        }
        for(int i =index+1; i<= s.length();i++){
            if(isPalindrome(s.substring(index, i))){
                palindrome.add(s.substring(index, i));
                dfs(s, i , palindrome, result);
                palindrome.remove(palindrome.size()-1);

            }
        }
    }

    private boolean isPalindrome(String s){

        for (int i = 0; i <= s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }

        }
        return true;
    }
}
