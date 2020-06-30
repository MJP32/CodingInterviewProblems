package Leetcode.topic.string;

import java.util.*;

public class LC316_RemoveDuplicateLetters {
    public static void main(String[] args) {
        /*
        Given a string which contains only lowercase letters,
        remove duplicate letters so that every letter appears once and only once.
        You must make sure your result is the smallest in lexicographical order among all possible results.

        Example 1:

        Input: "bcabc"
        Output: "abc"
        Example 2:

        Input: "cbacdcbc"
        Output: "acdb"


        */

        System.out.println(new LC316_RemoveDuplicateLetters().removeDuplicateLetters("bcabc"));
        System.out.println(new LC316_RemoveDuplicateLetters().removeDuplicateLetters("cbacdcbc"));
    }
    public String removeDuplicateLetters(String s) {

        int [] lastSeen = new int[26];
        Arrays.fill(lastSeen,-1);

        for (int i = 0; i < s.length(); i++) {
            lastSeen[s.charAt(i )- 'a'] = i;
        }

        Set<Character> used = new HashSet<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr =s.charAt(i);
            if (used.contains(curr)) {
                continue;
            }

            while(!stack.isEmpty() && stack.peek() >curr &&lastSeen[stack.peek() -'a'] >i){
                used.remove(stack.pop());
            }
            used.add(curr);
            stack.push(curr);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();





/*
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < lastSeen.length; i++) {


            if(lastSeen[i] != -1) {map.put((char)(97 + i), lastSeen[i] );}
        }

        StringBuilder sb = new StringBuilder();
        map
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.naturalOrder()))
                .forEachOrdered(x-> sb.append(x.getKey()));

       return sb.toString();*/
    }
}
