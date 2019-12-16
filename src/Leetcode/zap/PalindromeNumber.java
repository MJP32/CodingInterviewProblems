package Leetcode.zap;

public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber pn = new PalindromeNumber();
        System.out.println(pn.isPalindrome3(121));
        System.out.println(pn.isPalindrome3(-121));
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
