package AlgoExpert.string;

import java.util.HashMap;

public class PatternMatcher2 {
    public static void main(String[] args) {
        String[] dict = {"abb", "abc","zss",
                "xyz", "xyy", "xxyxxy", "gogopowerrangergogopowerranger"};
        String pattern = "foo";

        findMatchedWords(dict, pattern);
//        System.out.println(Arrays.toString(patterMatcher("xxyxxy", "gogopowerrangersgogopowerranger")));
    }

    static void findMatchedWords(            String[] dict, String pattern) {
        // len is length of the pattern
        int len = pattern.length();

        // encode the string
        String hash = encodeString(pattern);

        // for each word in the dictionary array
        for (String word : dict) {
            // If size of pattern is same
            // as size of current
            // dictionary word and both
            // pattern and the word
            // has same hash, print the word
            if (word.length() == len
                    && encodeString(word).equals(hash))
                System.out.print(word + " ");
        }
    }

    // Function to encode given string
    static String encodeString(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        String res = "";
        int i = 0;

        // for each character in given string
        char ch;
        for (int j = 0; j < str.length(); j++) {
            ch = str.charAt(j);

            // If the character is occurring for the first
            // time, assign next unique number to that char
            if (!map.containsKey(ch))
                map.put(ch, i++);

            // append the number associated with current
            // character into the output string
            res += map.get(ch);
        }

        return res;
    }


}
