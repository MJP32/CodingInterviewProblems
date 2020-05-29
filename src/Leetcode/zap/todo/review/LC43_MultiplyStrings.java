package Leetcode.zap.todo.review;

public class LC43_MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(new LC43_MultiplyStrings().multiply("16", "24"));
    }
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] answer = new int[m + n];

        for (int i = m - 1; i >= 0; i --) {
            for (int j = n - 1; j >= 0; j --) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = answer[i + j + 1] + mul;
                answer[i + j] += sum / 10;
                answer[i + j + 1] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int val : answer) {
            //dont add zero in front
            if (!(val == 0 && sb.length() == 0)) {
                sb.append(val);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
