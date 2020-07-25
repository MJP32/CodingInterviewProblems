package Leetcode.topic.string;

import java.util.ArrayList;
import java.util.List;

public class LC1324_PrintWordsVertically {
    public static void main(String[] args) {
        new LC1324_PrintWordsVertically().printVertically("HOW ARE YOU").forEach(k -> System.out.println(k));
        new LC1324_PrintWordsVertically().printVertically("TO BE OR NOT TO BE").forEach(k -> System.out.println(k));
    }

    public List<String> printVertically(String s) {
        List<String> result = new ArrayList<>();
        String[] words = s.split(" ");
        int max = 0;
        for (String word : words) {
            max = Math.max(max, word.length());
        }
        int idx = 0;
        while (idx < max) {
            String currWord = "";
            for (String word : words) {
                if (idx < word.length())
                    currWord += word.charAt(idx);
                else
                    currWord +=" ";
            }
            result.add(removeTrailingSpaces(currWord));
            idx++;
        }
        return result;
    }

    public static String removeTrailingSpaces(String param)
    {
        if (param == null)
            return null;
        int len = param.length();
        for (; len > 0; len--) {
            if (!Character.isWhitespace(param.charAt(len - 1)))
                break;
        }
        return param.substring(0, len);
    }
}
