package Leetcode.zap.todo.review.facebook;

import java.util.*;

public class LC140_WordBreak2YT {
    public static void main(String[] args) {

        new LC140_WordBreak2YT().wordBreak("leetcode", Arrays.asList("leet", "code")).forEach(k->
                System.out.println(k));
        new LC140_WordBreak2YT().wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")).forEach(k-> System.out.println(k));

        new LC140_WordBreak2YT().wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine",
                "pineapple")).forEach(k-> System.out.println(k));
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreak( s, wordDict, new HashMap<String, List<String>>());
    }

    private List<String> wordBreak(String s, List<String> wordDict, Map<String, List<String>> memo) {

        if(memo.containsKey(s)){
            return memo.get(s);
        }

        List<String> results= new ArrayList<>();

        if(s.length() ==0){
            results.add("");
            return results;
        }

        for (String word : wordDict){
            if(s.startsWith(word)){

                String remainderOfString = s.substring(word.length());

                List<String> subStrings =
                        wordBreak(remainderOfString, wordDict, memo);
                for(String subString : subStrings){
                    results.add((word +" " + subString).trim());
                }
            }
        }

        memo.put(s, results);
        return results;
    }

}
