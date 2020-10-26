package Leetcode.pattern.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC22_GenerateParenthesis {
    public static void main(String[] args) {
        //Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
        /* For example, given n = 3, a solution set is:

        [
          "((()))",
          "(()())",
          "(())()",
          "()(())",
          "()()()"
        ]
        */
        new LC22_GenerateParenthesis().generateParenthesis(3).forEach(k-> System.out.println(k));
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(list, "", n, n );
        return list;
    }

    private void helper(List<String> result, String curr, int left, int right) {
//        System.out.println(left +" "+ right + " " + curr);
        if (left < 0 || left> right) {
            return;
        }
        if (left ==0 && right ==0) {
            result.add(curr);
            return;
        }
        helper(result, curr + "(", left-1, right);
        helper(result, curr + ")", left, right-1);
    }
}
