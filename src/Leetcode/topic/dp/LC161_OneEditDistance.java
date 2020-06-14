package Leetcode.topic.dp;

public class LC161_OneEditDistance {
    public static void main(String[] args) {

    }
    public boolean isOneEditDistance(String s, String t) {
        int i = 0;
        while (i<s.length() && i<t.length()) {
            if (s.charAt(i) != t.charAt(i)) {
                return s.substring(i+1).equals(t.substring(i+1))
                        || s.substring(i+1).equals(t.substring(i))
                        || s.substring(i).equals(t.substring(i+1));
            }
            i++;
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}
