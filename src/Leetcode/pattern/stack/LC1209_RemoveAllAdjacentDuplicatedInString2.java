package Leetcode.pattern.stack;

import java.util.Stack;

public class LC1209_RemoveAllAdjacentDuplicatedInString2 {
    public static void main(String[] args) {

    }
    public String removeDuplicates(String s, int k) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);

        for(int i = 0; i < sb.length();i++){
            if(i ==0 || sb.charAt(i) != sb.charAt(i-1)){
                stack.push(1);
            }
            else{
                int incremented = stack.pop()+1;
                if(incremented == k){
                    sb.delete(i-k+1, i+1);
                    i = i-k;
                }
                else{
                    stack.push(incremented);
                }
            }
        }
        return sb.toString();
    }
}
