package Grokking.Ch1_SlidingWindow.problem;


import java.util.ArrayList;
import java.util.List;

class StringPermutation {
    public static void main(String[] args) {
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("oidbcaf", "abc"));
       System.out.println("Permutation exist: " + StringPermutation.findPermutation("odicf", "dc"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("aaacb", "abc"));
    }

    public static boolean findPermutation(String str, String pattern) {
        // TODO: Write your code here


        for (int i = 0; i < str.length() - 2; i++) {

            if(containsPermutaion(str.substring(i, i+3), pattern)){
                return true;
            }

        }

        return false;
    }

    private static boolean containsPermutaion(String substring, String pattern) {



        List<String> patternPermutaions= getPermutaions(pattern);


        for (String patternPerm : patternPermutaions){
            if (substring.equals(patternPerm))
                return true;
        }



        return false;
    }

    private static List<String> getPermutaions(String pattern) {

        List<String> results = new ArrayList<>();


        permutations(pattern .toCharArray(), 0, results);


        return results;
    }

    private static void swap(char[] ch, int i, int j)
    {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

    // Recursive function to generate all permutations of a String
    private static void permutations(char[] ch, int currentIndex, List<String> results)
    {
        if (currentIndex == ch.length - 1) {
            //System.out.println(String.valueOf(ch));
            results.add(String.valueOf(ch));
        }

        for (int i = currentIndex; i < ch.length; i++)
        {
            swap(ch, currentIndex, i);
            permutations(ch, currentIndex + 1, results);
            swap(ch, currentIndex, i);
        }
    }
}