package Leetcode.zap.todo.finish;

import java.util.*;

public class LC524_LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {

        LC524_LongestWordInDictionaryThroughDeleting lc524 = new LC524_LongestWordInDictionaryThroughDeleting();

        String s = "abpcplea";
        List<String> d = new ArrayList<>();

        d.add("ale");
        d.add("apple");
        d.add("monkey");
        d.add("plea");

        System.out.println();

        System.out.println(lc524.findLongestWord(s, d));

        //d.forEach(k-> System.out.println(k));

    }

        public String findLongestWord(String s, List<String> d) {
            if(s == null || d == null || d.size() == 0){
                return "";
            }

            Collections.sort(d, Comparator.comparingInt(String::length).reversed());


            String res = "";
            for(String word : d){
                int i = 0;
                for(char c : s.toCharArray()){
                    if(i<word.length() && c == word.charAt(i)){
                        i++;
                    }
                }

                if(i == word.length()){
                    return word;
                }

                //No need to presort if using this
                /*if(i == word.length()){
                    if(res.length() < word.length()){
                        res = word;
                    }else if(res.length() == word.length() && res.compareTo(word)>0){
                        res = word;
                    }
                }*/
            }

            return res;
        }



}
