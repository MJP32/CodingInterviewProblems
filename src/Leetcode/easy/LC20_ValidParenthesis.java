package Leetcode.easy;

import java.util.Stack;

public class LC20_ValidParenthesis {
    public static void main(String[] args) {
        LC20_ValidParenthesis lc20 = new LC20_ValidParenthesis();
        System.out.println(lc20.isValid("()"));
        System.out.println(lc20.isValid("(]"));
        System.out.println(lc20.isValid("]"));
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        boolean result = false;
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            else if(c == ')' || c == '}' || c == ']'){


                if(!stack.isEmpty())
                    result = isEqual(stack.pop(), c);
                if(result == false){
                    return false;
                }
            }


        }

        if(stack.isEmpty()){
            return true;
        }
        else{
            return false;
        }

    }

    private boolean isEqual(Character s, Character c){

        if((s=='(' && c==')') || (s=='{' && c=='}') || (s=='[' && c==']'))
            return true;
        else
            return false;
    }
}
