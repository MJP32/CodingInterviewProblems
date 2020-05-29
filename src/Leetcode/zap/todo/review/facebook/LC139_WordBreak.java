package Leetcode.zap.todo.review.facebook;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC139_WordBreak {
    public static void main(String[] args) {

        System.out.println(new LC139_WordBreak().wordBreak("leetcode", Arrays.asList(new String[]{"leet","code"})));
//        System.out.println(LC139_WordBreak.wordBreak("Iamc", Arrays.asList(new String[]{"I" , "am " , "ace" , "a"
//        })));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {

        Set<String> wordDictSet=new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                System.out.println(s.substring(j, i));
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[s.length()];


    }


}
