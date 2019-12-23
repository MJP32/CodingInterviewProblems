package Leetcode.zap.todo;

import java.util.ArrayList;
import java.util.List;

public class LC22_GenerateParenthesis {
    public static void main(String[] args) {
        LC22_GenerateParenthesis lc22 =new LC22_GenerateParenthesis();
        lc22.generateParenthesis(3).forEach(k-> System.out.println(k));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(n,n,"", result);

        return result;

    }

    private void helper(int left, int right, String curr, List<String> result) {

        if(left <0 || left>right){
            return;
        }
        if(left ==0 && right ==0){
            result.add(curr);
            return;
        }

        helper(left -1, right, curr+"(", result);
        helper(right-1, left, curr+")" , result);

    }
}
