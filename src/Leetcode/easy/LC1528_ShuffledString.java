package Leetcode.easy;

public class LC1528_ShuffledString {
    public static void main(String[] args) {
        System.out.println(new LC1528_ShuffledString().restoreString("codeleet", new int[]{4,5,6,7,0,2,1,3}));
    }
    public String restoreString(String s, int[] indices) {


        char[] res = new char[s.length()];
        for(int i = 0; i < s.length(); i++){
            res[indices[i]] = s.charAt(i);
        }
        return String.valueOf(res);
    }
}
