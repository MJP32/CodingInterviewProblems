package Leetcode.zap.todo.review.facebook;

import java.util.*;

public class LC139_WordBreak {
    public static void main(String[] args) {

        System.out.println(new LC139_WordBreak().wordBreakBFS("leetcode", Arrays.asList(new String[]{"leet", "code"})));
//        System.out.println(new LC139_WordBreak().wordBreakDP("leetcode", Arrays.asList(new String[]{"leet","code"})));
        System.out.println(new LC139_WordBreak().wordBreakDP("applepenapple", Arrays.asList(new String[]{"pen",
                "apple"})));
//        System.out.println(new LC139_WordBreak().wordBreakRecursion("leetcode", Arrays.asList(new String[]{"leet","code"})));
//        System.out.println(new LC139_WordBreak().wordBreakRecursionMemo("leetcode", Arrays.asList(new String[]{"leet",
//                "code"})));

    }

    public static boolean wordBreakBFS(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);

        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;

    }

    public static boolean wordBreakDP(String s, List<String> wordDict) {

        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[s.length()];


    }

    public boolean wordBreakRecursion(String s, List<String> wordDict) {
        List<String> results = new LinkedList<>();
        wordBreakRecursion(new ArrayList<String>(), s, wordDict, results);
        return results.size() > 0;
    }

    private void wordBreakRecursion(List<String> curr, String remainder, List<String> wordDict, List<String> results) {
        if (remainder.length() == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < curr.size() - 1; i++) {
                sb.append(curr.get(i) + " ");
            }
            sb.append(curr.get(curr.size() - 1));
            results.add(sb.toString());

            //System.out.println(sb.toString());
            return;
        }

        for (int i = 1; i <= remainder.length(); i++) {
            String substr = remainder.substring(0, i);
            if (wordDict.contains(substr)) {
                curr.add(substr);
                wordBreakRecursion(curr, remainder.substring(i, remainder.length()), wordDict, results);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public boolean wordBreakRecursionMemo(String s, List<String> wordDict) {
        return wordBreakRecursionMemo(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }

    public boolean wordBreakRecursionMemo(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakRecursionMemo(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }


}
