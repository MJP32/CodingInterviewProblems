package bytebybyte.module2;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerateAllSubstring {
    public static void main(String[] args) {

        //substringsIter("abc").forEach(k-> System.out.println(k));
        substringsRecursive("abc").forEach(k-> System.out.println(k));
    }

    private static List<String> substringsRecursive(String s) {
        List<String> result = new LinkedList<>();
        iterateOverFirstCharacters(s,0,result);
        return result;
    }

    private static void iterateOverFirstCharacters(String s, int i, List<String> result) {

        if (i>=s.length()) {
            return;
        }
        iterateOverSecondCharacters( s,  i,  i+1, result);
        iterateOverFirstCharacters( s,  i+1, result);
    }

    private static void iterateOverSecondCharacters(String s, int i, int j, List<String> result) {
        if (j > s.length()) {
            return;
        }
        result.add(s.substring(i,j));
        iterateOverSecondCharacters(s, i, j+1, result);
    }


    public static List<String> substringsIter(String s){
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length() ; j++) {
                result.add(s.substring(i, j));
            }
        }
        return result;
    }



}
