package Pramp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class WordCountEngine {
    public static void main(String[] args) {
String word = "Practice makes perfect. you'll only get Perfect by practice. just practice!";
        System.out.println(Arrays.deepToString(wordCountEngine(word)));
    }
    static String[][] wordCountEngine(String document) {
        document = document.replaceAll("[\\.'!;,:\\?]", "");
        document = document.toLowerCase();

        String[] strArr = document.split("\\s+");

        Map<String,Integer> map = new HashMap<>();

        for (String s: strArr) {
            map.put(s, map.getOrDefault(s,0)+1);
        }

        String[][] str = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(e->new String[]{e.getKey(), String.valueOf(e.getValue())})
                .toArray(String[][]::new);

        return str;
    }
}
