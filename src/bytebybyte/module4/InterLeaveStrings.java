package bytebybyte.module4;


import java.util.LinkedList;
import java.util.List;

public class InterLeaveStrings {
    public static void main(String[] args) {
        interleave("ab", "cd").forEach(k-> System.out.println(k));

    }

    private static List<String> interleave(String s1, String s2) {

       List<String> results = new LinkedList<>();
       interleave(s1,s2,0,0,new StringBuilder(),  results);
        return results;
    }

    private static void interleave(String s1, String s2, int i, int j, StringBuilder path, List<String> results) {
        if (i == s1.length() && j ==s2.length()) {
            results.add(path.toString());
            return;
        }
        if (i < s1.length()) {
            path.append(s1.charAt(i));
            interleave(s1, s2, i+1, j, path, results);
            path.setLength(path.length()-1);

        }
        if (j < s2.length()) {
            path.append(s2.charAt(j));
            interleave(s1, s2, i, j+1, path, results);
            path.setLength(path.length()-1);

        }


    }
}
