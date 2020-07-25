package Leetcode.easy;

import java.util.Stack;

public class LC_BackSpaceCompare {
    public static void main(String[] args) {
        System.out.println(new LC_BackSpaceCompare().backspaceCompare("y#fo##f",
                "y#f#o##f"));
    }

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (int i = 0; i < S.length(); i++) {

            if (S.charAt(i) == '#' && stack1.size() != 0) {
                stack1.remove(stack1.size() - 1);
            } else {
                if (S.charAt(i) != '#')
                    stack1.add(S.charAt(i));
            }
        }

        for (int i = 0; i < T.length(); i++) {

            if (T.charAt(i) == '#' && stack2.size() != 0) {
                stack2.remove(stack2.size() - 1);
            } else {
                if (T.charAt(i) != '#')
                    stack2.add(T.charAt(i));
            }
        }

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (Character c : stack1)
            sb1.append(c);


        for (Character c : stack2)
            sb2.append(c);

        return sb1.toString().equals(sb2.toString());

    }
}
