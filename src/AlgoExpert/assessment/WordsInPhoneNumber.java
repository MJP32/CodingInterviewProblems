package AlgoExpert.assessment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordsInPhoneNumber {
    public static void main(String[] args) {
        WordsInPhoneNumber wordsInPhoneNumber = new WordsInPhoneNumber();
        //lc17.letterCombinations("23").forEach(k-> System.out.println(k));

        wordsInPhoneNumber.wordsInPhoneNumber("3662277",new String[]{"foo","bar", "baz", "foobar","emo","cap",
                "car", "cat"}).forEach(k-> System.out.println(k));
    }
    public static List<String> wordsInPhoneNumber(String phoneNumber, String[] words) {
        return letterCombinations(phoneNumber, words);

    }
    public static List<String> letterCombinations(String phoneNumber, String[] words) {
        List<String> result = new ArrayList<>();
        if(phoneNumber == null || phoneNumber.length()==0){
            return result;
        }


        String [] mappings = {
            "0",
            "1",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };

         letterCombinationsRecurse(result, phoneNumber, "", 0, mappings);

        Set<String> ans = new HashSet<>();
        for(String word: words){
            for (String res: result) {
                if(res.contains(word)){
                    ans.add(word);
                }
            }
         }

        return new ArrayList<>(ans);
    }

    private static void letterCombinationsRecurse(List<String> result, String digits, String current, int index,
                                                 String[] mappings) {
        if(index == digits.length()){
            result.add(current);
            return;
        }

        String letters = mappings[digits.charAt(index) -'0'];
        for (int i = 0; i < letters.length(); i++) {
            letterCombinationsRecurse(result,digits,current+letters.charAt(i), index+1, mappings);
        }



    }
}

