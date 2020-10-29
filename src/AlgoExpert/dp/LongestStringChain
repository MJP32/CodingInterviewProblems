package AlgoExpert.dp;

import java.util.*;

public class LongestStringChain {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("e","z", "zz", "zzz", "abde", "abc", "abd", "zzzz", "abcde", "ade", "ae",
                "labde", "abcdef","zzzzzzzzzzzzzz");

        //  ans = abcdef abcde abde ade ae e
        //        List<String> words = Arrays.asList( "abde","ade","ae","abd", "e");

        longestStringChain(words).forEach(k -> System.out.print(k + " "));


    }

    public static List<String> longestStringChain(List<String> strings) {
        Collections.sort(strings, Comparator.comparingInt(String::length));
        Map<String, StringChain> stringChains = new HashMap<>();
        for (String str : strings) {
            stringChains.put(str, new StringChain("", 1));
        }
        for (String str : strings) {
            findLongestStringChain(str, stringChains);
        }
        return buildLongestList(strings, stringChains);
    }

    private static List<String> buildLongestList(List<String> strings, Map<String, StringChain> stringChains) {
        int maxChainLength = 0;
        String startingString = "";
        //System.out.println(stringChains);
        for (String str : strings) {
            if (stringChains.get(str).maxChainLength > maxChainLength) {
                startingString = str;
                maxChainLength = stringChains.get(str).maxChainLength;
            }
        }
        List<String> longestList = new ArrayList<>();
        String currentString = startingString;
        while (currentString != "") {
            longestList.add(currentString);
            currentString = stringChains.get(currentString).nextChain;
        }
        return longestList;
    }

    private static void findLongestStringChain(String str, Map<String, StringChain> stringChains) {
        for (int i = 0; i < str.length(); i++) {
            String subString = str.substring(0, i) + str.substring(i + 1);
            if (stringChains.containsKey(subString))
                tryUpdateStringChain(str, subString, stringChains);
        }
    }

    private static void tryUpdateStringChain(String str, String subString, Map<String, StringChain> stringChains) {
        int strLength = stringChains.get(str).maxChainLength;
        int subStringLength = stringChains.get(subString).maxChainLength;
        if (strLength < subStringLength + 1) {
            stringChains.get(str).maxChainLength = subStringLength + 1;
            stringChains.get(str).nextChain = subString;
        }
    }
}

class StringChain {
    String nextChain;
    Integer maxChainLength;

    public StringChain(String nextChain, Integer maxChainLength) {
        this.nextChain = nextChain;
        this.maxChainLength = maxChainLength;
    }

    @Override
    public String toString() {
        return "StringChain{" +
                "nextChain='" + nextChain + '\'' +
                ", maxChainLength=" + maxChainLength +
                '}';
    }
}
