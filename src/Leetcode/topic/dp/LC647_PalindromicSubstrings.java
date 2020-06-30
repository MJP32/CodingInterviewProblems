package Leetcode.topic.dp;

public class LC647_PalindromicSubstrings {
    public int countSubstrings(String s) {
        int ans = 0;
        for(int i = 0; i<s.length(); i++){
            int odd = palin(s,i,i); // palindrome of odd length
            int even = palin(s,i,i+1);  //palindrome of even length
            ans+=even+odd;
        }
        return ans;
    }
    public int palin(String s, int l , int r){
        int count = 0;
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            count++;
            l--;
            r++;
        }
        return count;
    }
}

