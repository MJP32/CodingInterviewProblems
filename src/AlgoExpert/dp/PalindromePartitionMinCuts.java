package AlgoExpert.dp;

import java.util.Arrays;

public class PalindromePartitionMinCuts {
    public static void main(String[] args) {
        System.out.println(palindromePartitioningMinCuts("noonabbad"));
    }
    public static int palindromePartitioningMinCuts(String str) {

        boolean [][] palindromes = new boolean[str.length()][str.length()];
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                palindromes[i][j] = isPalindrome(str.substring(i,j+1));
            }
        }
        int[] cuts = new int[str.length()];
        Arrays.fill(cuts, Integer.MAX_VALUE);
        for (int i = 0; i < str.length(); i++) {
            if (palindromes[0][i]) {
                cuts[i] =0;
            }
            else{
                cuts[i] = cuts[i-1]+1;
                for (int j = 1; j < i; j++) {
                    if (palindromes[j][i] && cuts[j - 1] + 1 < cuts[i]) {
                        cuts[i] = cuts[j - 1] + 1;
                    }
                }
            }
        }
        return cuts[str.length()-1];
    }

    private static boolean isPalindrome(String str){
        int i =0;
        int j = str.length()-1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;

        }
        return true;
    }



}
