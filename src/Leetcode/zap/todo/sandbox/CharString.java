package Leetcode.zap.todo.sandbox;

public class CharString {
    public static void main(String[] args) {

        System.out.println(new CharString().findTheDifference("abcd","abcde"));
    }
    public char findTheDifference(String s, String t) {

        char[] ch = new char[26];

        for (char c: s.toCharArray()){
            ch[c-'a']++;
        }

        for (char c: t.toCharArray()){
            if (ch[c-'a'] > 0)
                ch[c-'a']--;
            else
                ch[c-'a']++;
        }

        for (int i=0; i<26; i++){
            if (ch[i] > 0)
                return (char)('a'+ i);
        }

        // doesn't matter as we'll always have an answer based on given input
        return s.charAt(0);
    }
}
