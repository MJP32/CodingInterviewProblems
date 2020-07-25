package Leetcode.easy;

import Leetcode.zap.todo.review.facebook.LC415_AddStrings;

public class LC415_AddString {
    public static void main(String[] args) {
        System.out.println(new LC415_AddStrings().addStrings("1123",     "937"));
    }
    public String addStrings(String num1, String num2) {


        int m = num1.length(), n = num2.length();
        StringBuilder sb = new StringBuilder();

        int i = m - 1, j = n - 1;
        int sum = 0;
        while (i >= 0 || j >= 0 || sum != 0) {
            if (i >= 0) {
                sum += num1.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += num2.charAt(j) - '0';
                j--;
            }
            sb.insert(0, sum % 10);
            sum /= 10;
        }





        return sb.toString();
    }
}
