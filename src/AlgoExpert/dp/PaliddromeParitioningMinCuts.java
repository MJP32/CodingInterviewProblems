package AlgoExpert.dp;

import java.util.ArrayList;
import java.util.List;

public class PaliddromeParitioningMinCuts {
    public static void main(String[] args) {
        System.out.println(new PaliddromeParitioningMinCuts().partition("noonabbad"));
    }

    public int partition(String s ){
        List<List<String>> result = new ArrayList<>();
        int min = dfs(s, 0, new ArrayList<>(), result, Integer.MAX_VALUE);
        //result.forEach(k-> System.out.println(k));
        return min;
    }

    private int dfs(String s, int index, ArrayList<String> palindrome, List<List<String>> result, int min) {
        if(index == s.length()){
            min= Math.min(min, palindrome.size());
            result.add(new ArrayList<>(palindrome));
            return min;
        }
        for(int i =index+1; i<= s.length();i++){
            if(isPalindrome(s.substring(index, i))){
                palindrome.add(s.substring(index, i));
                min =dfs(s, i , palindrome, result, min);
                palindrome.remove(palindrome.size()-1);

            }
        }
        return min;
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
