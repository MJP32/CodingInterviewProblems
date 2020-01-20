package Leetcode.zap.todo.finish;

import java.util.Stack;

public class LC394_DecodeString {
    public static void main(String[] args) {

        LC394_DecodeString lc394 = new LC394_DecodeString();
        System.out.println(lc394.decodeString("3[a]2[bc]"));
    }
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();


        /*
             while (idx < s.length()) {
                1.  for each lettter check if it is digit, if it is get all digits
                2.  put the number on the stack, increment idx for each digit






        */



        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            else if (s.charAt(idx) == '[') {
                //push letter on stack 2nd stack
                resStack.push(res);
                res = "";
                idx++;
            }
            else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                //get letter
                res += s.charAt(idx++);
            }
        }
        return res;



    }
}
