package Leetcode.topic.stack;

import java.util.Stack;

public class LC917_ReverseOnlyLetters {
    public static void main(String[] args) {
        LC917_ReverseOnlyLetters lc917 = new LC917_ReverseOnlyLetters();
        System.out.println(lc917.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }

    public String reverseOnlyLetters(String S) {
        Stack<Character> letters = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if(Character.isLetter(S.charAt(i))){
                letters.push(S.charAt(i));
            }
        }

        for (int i = 0; i < S.length(); i++) {
            if(!Character.isLetter(S.charAt(i))){
                result.append(S.charAt(i));
            }
            else{
                result.append(letters.pop());
            }
        }
        return result.toString();
    }
}
