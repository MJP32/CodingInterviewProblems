package Leetcode.pattern.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC282_ExpressionAddOperators {


    public static void main(String[] args) {
        System.out.println(new LC282_ExpressionAddOperators().addOperators("123", 6));
    }

    public List<String> addOperators(String num, int target) {
        if (num == null || num.length() == 0)
            return new ArrayList<>();

        result = new ArrayList<>();
        this.target = target;
        chars = num.toCharArray();
        N = num.length();

        StringBuilder sb = new StringBuilder();
        sb.append(chars[0]);
        int digit = chars[0] - '0';

        backtrack(1, sb, digit, digit, digit);

        return result;
    }

    int target;
    List<String> result;
    char[] chars;
    int N;

    private void backtrack(int cPtr, StringBuilder sb, long sum, long prevSum, long prevDigit) {
        if (cPtr == N) {
            if (sum == target) {
                result.add(sb.toString());
            }
            return;
        }
        char c = chars[cPtr];
        int digit = c - '0';

        /* No Operation - Append */
        // ignore situations where result of append might start with 0, to avoid cases like '1 + 03'
        if (prevDigit > 0) {
            // An example to make sence of the logic
            // Received => expression : 1-2*3| sum : -5 | prevSum : -6 | prevDigit : 3
            // current digit = 2 | new expression shall be => 1-2*32
            // Run through this logic with other example cases like "1-2+32", "1-2-32" (Where 2 is current digit)
            sb.append(c);
            long currentSum = prevSum * 10 + (prevSum / prevDigit) * digit; // -6*10+(-6/3)*2 => -64
            long totalSum = (sum - prevSum) + currentSum;                   // -5-(-6)+(-64)  => -63
            long currentDigit = prevDigit * 10 + digit;                     // 3*10 + 2       => 32
            backtrack(cPtr + 1, sb, totalSum, currentSum, currentDigit);
            sb.setLength(sb.length() - 1);
        }

        /* Add */
        sb.append('+').append(c);
        backtrack(cPtr + 1, sb, sum + digit, digit, digit);
        sb.setLength(sb.length() - 2);

        /* Subtract */
        sb.append('-').append(c);
        backtrack(cPtr + 1, sb, sum - digit, -digit, digit);
        sb.setLength(sb.length() - 2);

        /* Multiply */
        sb.append('*').append(c);
        long currentSum = prevSum * digit;
        long totalSum = (sum - prevSum) + currentSum;
        backtrack(cPtr + 1, sb, totalSum, currentSum, digit);  // Explained in many solutions
        sb.setLength(sb.length() - 2);
    }
}
