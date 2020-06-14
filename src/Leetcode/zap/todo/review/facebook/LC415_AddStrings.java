package Leetcode.zap.todo.review.facebook;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC415_AddStrings {
    public static void main(String[] args) {
        System.out.println(new LC415_AddStrings().addStrings("1234", "1234" ));
    }
    public String addStrings(String num1, String num2) {

        StringBuilder sb = new StringBuilder();
        int i = num1.length()-1;
        int j = num2.length()-1;
        int sum = 0;
        int carry = 0;
        while (i >=0 ||j >=0) {
            sum +=carry;
            carry =0;

            if (i>=0) {
               sum += num1.charAt(i--) - '0';
            }
            if (j>=0) {
                sum += num2.charAt(j--) - '0';
            }
            sb.append(sum %10);
            carry = sum/10;
            sum =0;
        }
        return sb.reverse().toString();
    }


}
