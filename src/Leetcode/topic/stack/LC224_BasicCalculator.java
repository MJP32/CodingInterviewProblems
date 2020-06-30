package Leetcode.topic.stack;

import java.util.Stack;

public class LC224_BasicCalculator {
    public static void main(String[] args) {
        System.out.println(new LC224_BasicCalculator().calculate("1+8"));
//        System.out.println(new LC224_BasicCalculator().calculate("(1+(4+5+2)-3)+(6+8)"));
    }
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int evaluation = 0;
        int operand = 0;
        int sign =1;
        for(char c : s.toCharArray()){
            if (Character.isDigit(c)) {
                operand = operand * 10 + c -'0';
            }
            else if(c == '+'){
                evaluation += sign * operand;
                operand =0;
                sign =1;
            }
            else if(c == '-'){
                evaluation += sign * operand;
                sign =-1;
                operand =0;
            }
            else if(c == '('){
                stack.push(evaluation);
                stack.push(sign);
                evaluation =0;
                sign =1;
            }
            else if(c == ')'){
                evaluation +=sign * operand;
                evaluation *=stack.pop();
                evaluation +=stack.pop();
                operand =0;

            }
        }
        return evaluation+sign*operand;

    }
}
