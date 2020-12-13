package Bloomberg;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        System.out.println(subsets("abc"));
    }

    public static List<String> subsets(String str) {
        List<String> result = new ArrayList<>();
        getSubsets(str, 0, new StringBuilder(), result);
        return result;
    }

    public static void getSubsets(String str, int idx, StringBuilder curr, List<String> result) {

        if (curr.length() > 0)
            result.add(curr.toString());

        for (int i = idx; i < str.length(); i++) {
            curr.append(str.charAt(i));
            getSubsets(str, i + 1, curr, result);
            curr.deleteCharAt(curr.length() - 1);
        }


    }
}
