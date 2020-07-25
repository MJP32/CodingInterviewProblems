package Leetcode.zap.todo.review.facebook;

import java.util.*;

public class LC140_WordBreak2 {
    public static void main(String[] args) {

        new LC140_WordBreak2().wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")).forEach(k-> System.out.println(k));

        new LC140_WordBreak2().wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine",
                "pineapple")).forEach(k-> System.out.println(k));
    }
    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String> results = new LinkedList<>();
        wordBreak(new ArrayList<String>(), s,wordDict, results, new HashMap<String, List<String>>());
        return results;



    }
    private void wordBreak(List<String> curr, String remainder, List<String> wordDict, List<String> results,
                           Map<String, List<String>> memo) {


        if(remainder.length()==0){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < curr.size(); i++) {
                sb.append(curr.get(i) + " ");
            }
            results.add(sb.toString().trim());
            return ;
        }


        if(memo.containsKey(remainder)){
            return;
        }
        for (int i = 1; i <= remainder.length(); i++) {
            String substr = remainder.substring(0,i);
            if (wordDict.contains(substr)) {
                curr.add(substr);
                wordBreak(curr, remainder.substring(i, remainder.length()),wordDict, results, memo );
                curr.remove(curr.size()-1);
            }
        }
        memo.put(remainder, results);
    }
}
