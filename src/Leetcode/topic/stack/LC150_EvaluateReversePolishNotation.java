package Leetcode.topic.stack;

import java.util.Stack;

public class LC150_EvaluateReversePolishNotation {
    public static void main(String[] args) {
//        System.out.println(new LC150_EvaluateReversePolishNotation().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(new LC150_EvaluateReversePolishNotation().evalRPN(new String[]{"4","13","5","/","+"}));
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            if(!("+-*/").contains(token)){
                stack.push(Integer.valueOf(token));
                continue;
            }

            //second num on first for division
            int num2 = stack.pop();
            int num1 = stack.pop();
            int result =0;
            if(token.equals("+")){
                result = num1+num2;
            }
            else if(token.equals("-")){
                result = num1-num2;

            }
            else if(token.equals("*")){
                result = num1*num2;

            }
            else{
                result = num1/num2;

            }

            stack.push(result);
        }

        return stack.pop();
    }
}
