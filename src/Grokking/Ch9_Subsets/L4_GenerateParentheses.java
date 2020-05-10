package Grokking.Ch9_Subsets;

import java.util.*;

class GenerateParentheses {

    public static List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<String>();

        Queue<ParenthesisString> queue = new LinkedList<>();

        queue.add(new ParenthesisString("", 0,0));

        while (!queue.isEmpty()) {
            ParenthesisString ps = queue.poll();

            if (ps.openCount == num && ps.closeCount == num) {
                result.add(ps.str);
            } else {
                if (ps.openCount < num) {
                    queue.add(new ParenthesisString(ps.str + "(", ps.openCount + 1, ps.closeCount ));
                }

                if (ps.openCount > ps.closeCount) {
                    queue.add(new ParenthesisString(ps.str + ")", ps.openCount, ps.closeCount + 1));
                }

            }

        }

        return result;
    }

    public static void main(String[] args) {
        List<String> result = GenerateParentheses.generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = GenerateParentheses.generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }
}

class ParenthesisString{
    String str;
    int openCount;
    int closeCount;

    public ParenthesisString(String s, int openCount, int closeCount){
        str = s;
        this.openCount = openCount;
        this.closeCount =closeCount;
    }
}