package Leetcode.topic.string;

import java.util.ArrayList;
import java.util.List;

public class LC68_TextJustification {
    public static void main(String[] args) {
//        new LC68_TextJustification().fullJustify(new String[]{"This", "is", "an", "example", "of", "text",
//                "justification."}, 16).forEach(k-> System.out.println(k));
        new LC68_TextJustification().fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16).forEach(k-> System.out.println(k));
    }
    public List<String> fullJustify(String[] words, int maxWidth) {

       List<String> result = new ArrayList<>();
       int i =0;int n = words.length;
       while(i< n){
           int j = i+1;
           int lineLength = words[i].length();
           while (j<n && lineLength + words[j].length()+(j-i-1) < maxWidth) {
               lineLength +=words[j].length();
               j++;
           }
           int diff = maxWidth-lineLength;
           int numberOfWords = j-i;
           if (numberOfWords ==1 || j>=n) {
               result.add(leftJustify(words,diff,i,j));
           }
           else{

               result.add(leftJustify(words,diff,i,j));
           }
           i=j;
       }
       return result;
    }

    public String leftJustify(String[]words, int diff, int i, int j){
        int spacesOnRight=diff-(j-i-1);
        StringBuilder result=new StringBuilder(words[i]);
        for(int k=i+1;k<j;k++){
            result.append(" "+words[k]);
        }
        while(spacesOnRight>0) {
            result.append(" ");
            spacesOnRight--;
        }
        return result.toString();
    }
    public String middleJustify(String[] words ,int diff,int i,int j){
        int spacesNeeded=j-i-1; //Stores the sections where spaces are to be applied
        int spaces= diff/spacesNeeded; //min spaces to be applied b/w each word
        int extraSpaces=diff%spacesNeeded; //extra space to apply for distribution

        StringBuilder result=new StringBuilder(words[i]);
        for(int k=i+1;k<j;k++){
            int spacesToApply=spaces+(extraSpaces-- >0?1:0);
            while(spacesToApply>0) {
                result.append(" ");
            }spacesToApply--;
        }
        return result.toString();

    }


}
