package bytebybyte.module3;

import java.util.LinkedList;
import java.util.List;

public class GenerateSubstrings {
    public static void main(String[] args) {
        substrings("aaa").forEach(k-> System.out.println(k));
    }
    public static List<String> substrings(String s){
        List<String> result = new LinkedList<>();
        iterateOverFirstCharacters(s,0,result);
        return result;
    }

    private static void iterateOverFirstCharacters(String s, int i, List<String> result) {
        if (i>=s.length()) {
            return;
        }
        iterateOverSecondCharacters(s, i, i+1, result);
        iterateOverFirstCharacters(s, i+1, result);
    }

    private static void iterateOverSecondCharacters(String s, int i, int j, List<String> result) {
       if(j >s.length()){
           return;
       }
       result.add(s.substring(i,j));
       iterateOverSecondCharacters(s,i,j+1, result);
    }
}
