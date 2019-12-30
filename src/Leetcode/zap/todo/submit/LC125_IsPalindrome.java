package Leetcode.zap.todo.submit;

public class LC125_IsPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z^0-9]+", "");
        if(s == null ){
            return false;
        }

        for(int i=0; i< s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }
        }

        return true;
    }
}
