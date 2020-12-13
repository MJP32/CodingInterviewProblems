package FB.LC;


import java.util.Stack;

public class LC227_BasicCalculater2 {
    public static void main(String[] args) {
        System.out.println(new LC227_BasicCalculater2().calculate("3+2*2"));
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char lastOp = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
                if (lastOp == '+') {
                    stack.push(num);
                }
                if (lastOp == '-') {
                    stack.push(-1 * num);
                }
                if (lastOp == '*') {
                    stack.push(stack.pop() * num);
                }
                if (lastOp == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                lastOp = c;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}

