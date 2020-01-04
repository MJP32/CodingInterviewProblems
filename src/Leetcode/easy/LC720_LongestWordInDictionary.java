package Leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;

public class LC720_LongestWordInDictionary {
    public static void main(String[] args) {
        LC720_LongestWordInDictionary lc720 = new LC720_LongestWordInDictionary();
        //System.out.println(lc720.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
        System.out.println(lc720.longestWord(new String[]{"b","br","bre","brea","break","breakf","breakfa","breakfas","breakfast","l","lu","lun","lunc","lunch","d","di","din","dinn","dinne","dinner"}));
    }
    public String longestWord(String[] words) {
        String result ="";

        Arrays.sort(words);
        HashSet<String> builtWords = new HashSet<>();

        for(String str : words){
            if(str.length() ==1){
                builtWords.add(str);
                if(str.length() > result.length())
                    result =str;
            }
            else if(builtWords.contains(str.substring(0, str.length()-1))){
                builtWords.add(str);

                if(str.length() > result.length())
                    result = str;
            }
        }



        builtWords.forEach(k-> System.out.println(k));
        return result;
    }
}
