package Leetcode.topic.string;

import java.util.Arrays;

public class LC443_StringCompression {
    public static void main(String[] args) {
        System.out.println(new LC443_StringCompression().compress(new char[]{'a','a','b','b','b','a','a'}));
    }
    public int compress(char[] chars) {

        int i =0;
        int index =0;

        while (i< chars.length) {

            int j =i;
            while (j < chars.length && chars[i] == chars[j]) {
                j++;
            }

            chars[index++] = chars[i];
            if(j-i > 1){
                String count  = j-i+"";
                for(char c : count.toCharArray()){
                    chars[index++] = c;
                }
            }
            i =j;

        }
        System.out.println(Arrays.toString(chars));
        return index;
    }
}
