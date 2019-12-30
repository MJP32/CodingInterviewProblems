package Leetcode.zap.todo.review;

public class LC392_IsSubsequence {
    public static void main(String[] args) {
        LC392_IsSubsequence lc392 = new LC392_IsSubsequence();
        System.out.println(lc392.isSubsequence("abc", "ahbgdc"));
        System.out.println(lc392.isSubsequence("axc", "ahbgdc"));
    }
    public boolean isSubsequence(String s, String t) {

        int i =0;
        int j =0;
        while(j < t.length()){
            if(s.charAt(i) == t.charAt(j)){

                i++;
                if(i == s.length()){
                    return true;
                }
            }


           j++;
        }

        return false;
    }
}
