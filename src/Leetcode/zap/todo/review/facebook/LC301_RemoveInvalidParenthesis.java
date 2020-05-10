package Leetcode.zap.todo.review.facebook;

import java.util.ArrayList;
import java.util.List;

public class LC301_RemoveInvalidParenthesis {
    public static void main(String[] args) {
        System.out.println(new LC301_RemoveInvalidParenthesis().removeInvalidParentheses("()())()"));
        System.out.println(new LC301_RemoveInvalidParenthesis().removeInvalidParentheses("(a)())()"));
        System.out.println(new LC301_RemoveInvalidParenthesis().removeInvalidParentheses(")("));
    }
    public List<String> removeInvalidParentheses(String s) {

        int open =0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()){

            if(c == '('){
                open++;
            }
            else if(c ==')'){
                if(open ==0){
                    continue;
                }
                open--;
            }


            sb.append(c);
        }

        return new ArrayList<>();
    }
}
