package Leetcode.easy;

public class LC8_PalindromeNumber {

    public static void main(String[] args) {
        LC8_PalindromeNumber lc8 = new LC8_PalindromeNumber();
        System.out.println(lc8.isPalindrome2(121));
        System.out.println(lc8.isPalindrome2(-121));
    }


    public static boolean isPalindrome3(int x) {
        return String.valueOf(x).equals(new StringBuffer(String.valueOf(x)).reverse().toString());
    }
    public boolean isPalindrome2(int x) {
        int sum = 0,target = x;
        while (x > 0) {
            int temp = x % 10;
            x /= 10;
            sum = sum * 10 + temp;
        }
        return sum == target;
    }

}
