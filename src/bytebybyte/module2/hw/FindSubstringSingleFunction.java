package bytebybyte.module2.hw;

import java.util.LinkedList;
import java.util.List;

public class FindSubstringSingleFunction {
    public static void main(String[] args) {
        substringsRecursive("abcd").forEach(k-> System.out.println(k));
    }

    private static List<String> substringsRecursive(String s) {
        List<String> result = new LinkedList<>();
        substringsRecursive(s,0, 1, result);
        return result;
    }

    private static void substringsRecursive(String s, int i, int j, List<String> result) {

        if(i == s.length()){
            return;
        }

        if(j ==s.length()+1){
            substringsRecursive(s, i+1, i+2, result);
            return;
        }
        result.add(s.substring(i,j));
        substringsRecursive(s, i, j+1, result);

    }
}
