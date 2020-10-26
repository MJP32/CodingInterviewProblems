package bytebybyte.module6;

import java.util.ArrayList;
import java.util.List;

public class PrenthesizeExpression {
    public static void main(String[] args) {
//        parentheses("abcd").forEach(k-> System.out.println(k));
        new PrenthesizeExpression().diffWaysToCompute("2-1-1").forEach(k -> System.out.println(k));
    }

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '-' || ch == '+' || ch == '*') {
                String a = input.substring(0, i), b = input.substring(i + 1);
                List<Integer> al = diffWaysToCompute(a), bl = diffWaysToCompute(b);
                for (int x : al) {
                    for (int y : bl) {
                        ans.add(solve(x, y, ch));
                    }
                }
            }
        }
        if (ans.size() == 0) ans.add(Integer.parseInt(input));
        return ans;
    }

    public int solve(int n1, int n2, char ch) {
        if (ch == '+')
            n1 += n2;
        else if (ch == '-')
            n1 -= n2;
        else if (ch == '*')
            n1 *= n2;
        return n1;
    }

}
