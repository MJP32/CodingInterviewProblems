package bytebybyte.module3;

public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindrome("race"));
    }
    public static boolean isPalindrome(String s){
        if(s.length() <=1){
            return true;
        }

        return s.charAt(0) == s.charAt(s.length()-1) && isPalindrome(s.substring(1,s.length()-1));
    }
}
