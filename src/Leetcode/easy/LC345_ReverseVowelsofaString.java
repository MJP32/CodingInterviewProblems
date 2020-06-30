package Leetcode.easy;

import java.util.Stack;

public class LC345_ReverseVowelsofaString {
    public static void main(String[] args) {
        System.out.println(new LC345_ReverseVowelsofaString().reverseVowels("hello"));
    }
    public String reverseVowels(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character c: s.toCharArray()){
            if(c== 'a'||c=='e'||c=='i'||c=='o'||c=='u'||c== 'A'||c=='E'||c=='I'||c=='O'||c=='U'){
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0;i < s.length();i++){
            if(s.charAt(i)== 'a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'||
                    s.charAt(i)== 'A'||s.charAt(i)=='E'||s.charAt(i)=='I'||s.charAt(i)=='O'||s.charAt(i)=='U'){
                sb.append(stack.pop());
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
